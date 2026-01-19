package com.grpitsolutions.core.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import kotlinx.coroutines.NonCancellable.get
import org.koin.compose.viewmodel.koinViewModel
import kotlin.coroutines.EmptyCoroutineContext.get
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * A Composable that provides a [ViewModelStoreOwner] scoped to the lifecycle of a dialog or bottom sheet.
 *
 * This allows ViewModels to be created and managed within the scope of a dialog,
 * ensuring they are cleared when the dialog is dismissed, preventing memory leaks.
 *
 * @param visible A boolean indicating the visibility state of the dialog or sheet.
 * @param scopeId An optional unique identifier for the ViewModel store. A random UUID is generated if not provided.
 * @param content The composable content to be displayed within the dialog's ViewModel scope.
 */
@OptIn(ExperimentalUuidApi::class)
@Composable
fun DialogSheetScopedViewModel(
    visible: Boolean,
    scopeId: String = rememberSaveable { Uuid.random().toString() },
    content: @Composable () -> Unit,
) {
    val parentOwner =
        LocalViewModelStoreOwner.current ?: throw IllegalStateException("no parent owner found.")

    val registry = koinViewModel<ScopedStoreRegistryViewModel>(
        /** parent here could be activity or the nearest backstack enty,
         * doesn't matter
         * important is to be bound so can be clear and not generate any memory leakage */
        viewModelStoreOwner = parentOwner
    )

    var owner by remember { mutableStateOf<ViewModelStoreOwner?>(null) }

    LaunchedEffect(visible, scopeId) {
        if (visible && owner == null) {
            owner = object : ViewModelStoreOwner {
                override val viewModelStore: ViewModelStore
                    get() = registry.gerOrCreate(scopeId)
            }
        } else if (!visible && owner != null) {
            registry.clear(scopeId)
            owner = null
        }
    }

    owner?.let { dialogOwner ->
        CompositionLocalProvider(LocalViewModelStoreOwner provides dialogOwner) {
            content()
        }
    }
}