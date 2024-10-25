package com.example.myapplication.presentation.ui.inventoryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.InventoryItemRepository
import com.example.myapplication.domain.di.DomainModule
import com.example.myapplication.domain.models.InventoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryListViewModel @Inject constructor() : ViewModel() {

    private var firebaseConnector: InventoryItemRepository =
        DomainModule.provideInventoryItemRepository()

    private val _state = MutableStateFlow(InventoryListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            firebaseConnector.inventoryItems.collect(::collectInventoryItems)
        }
    }

    private fun collectInventoryItems(items: List<InventoryItem>) {
        _state.update { it.copy(listItems = items) }
    }

    fun foo() = viewModelScope.launch {
        firebaseConnector.getInventoryItems()
    }
}
