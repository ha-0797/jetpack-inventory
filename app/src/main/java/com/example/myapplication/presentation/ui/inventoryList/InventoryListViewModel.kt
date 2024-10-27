package com.example.myapplication.presentation.ui.inventoryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.InventoryItemRepository
import com.example.myapplication.domain.models.InventoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class InventoryListEvents {
    data object NewItem : InventoryListEvents()
}

fun inventoryListEventsCallbacks(
    events: InventoryListEvents,
    newItemCallback: Unit
) = when (events) {
    InventoryListEvents.NewItem -> newItemCallback
    else -> {}
}

@HiltViewModel
class InventoryListViewModel @Inject constructor(
    private val inventoryItemRepository: InventoryItemRepository
) : ViewModel() {

    private val _state = MutableStateFlow(InventoryListState())
    val state = _state.asStateFlow()

    private val _events = MutableSharedFlow<InventoryListEvents>()
    val events = _events.asSharedFlow()

    init {
        viewModelScope.launch {
            inventoryItemRepository.inventoryItems.collect(::collectInventoryItems)
        }
    }

    private fun collectInventoryItems(items: List<InventoryItem>) {
        _state.update { it.copy(isLoading = false, listItems = items) }
    }

    fun getInventoryItems() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            inventoryItemRepository.getInventoryItems()
        }.invokeOnCompletion {
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun openNewItemFragment() {
        viewModelScope.launch {
            _events.emit(InventoryListEvents.NewItem)
        }
    }
}
