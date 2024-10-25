package com.example.myapplication.domain

import com.example.myapplication.domain.models.InventoryItem
import kotlinx.coroutines.flow.StateFlow

interface InventoryItemRepository {

    val inventoryItems: StateFlow<List<InventoryItem>>

    fun getInventoryItems()
}