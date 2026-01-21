package com.grpitsolutions.core.designsystem.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.grpitsolutions.core.presentation.util.currentDeviceConfiguration

@Composable
fun ChirpAdaptiveDialogSheetLayout(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    val configuration = currentDeviceConfiguration()
    if(configuration.isMobile) {
        ChirpBottomSheet(
            onDismiss = onDismiss,
            content = content
        )
    } else {
        ChirpDialogContent(
            onDismiss = onDismiss,
            content = content
        )
    }
}