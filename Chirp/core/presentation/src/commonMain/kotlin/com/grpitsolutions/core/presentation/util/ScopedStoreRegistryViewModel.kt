package com.grpitsolutions.core.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore

/**
 * A [ViewModel] that manages and provides [ViewModelStore] instances scoped to a unique ID.
 * This allows for ViewModel lifecycles to be independently managed, for example,
 * when dealing with UI components like bottom sheets that require their own ViewModel scope.
 *
 * The [clear] and [onCleared] methods ensure that [ViewModelStore] references are properly
 * cleared, preventing memory leaks and allowing for garbage collection.
 */
class ScopedStoreRegistryViewModel : ViewModel() {

    private val stores = mutableMapOf<String, ViewModelStore>()

    /**
     * Retrieves an existing [ViewModelStore] associated with the given [id], or creates a new one if it doesn't exist.
     *
     * @param id The unique identifier for the [ViewModelStore].
     * @return The [ViewModelStore] associated with the provided [id].
     */
    fun gerOrCreate(id: String): ViewModelStore = stores.getOrPut(id) { ViewModelStore() }

    /**
     * Clears and removes the [ViewModelStore] associated with the given [id].
     * This releases all [ViewModel] instances held by that specific [ViewModelStore].
     *
     * @param id The unique identifier of the [ViewModelStore] to clear.
     */
    fun clear(id: String) {
        stores.remove(id)?.clear()
    }

    /**
     * Called when this [ScopedStoreRegistryViewModel] is being destroyed.
     * It clears all managed [ViewModelStore] instances, ensuring all associated ViewModels are also cleared.
     */
    override fun onCleared() {
        super.onCleared()
        stores.values.forEach { it.clear() }
        stores.clear()
    }

}
