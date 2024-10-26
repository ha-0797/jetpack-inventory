package com.example.myapplication.presentation.ui.inventoryList

import com.example.myapplication.domain.models.InventoryItem

data class InventoryListState(
    val isLoading: Boolean = false,
    val listItems: List<InventoryItem> = listOf()
)
