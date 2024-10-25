package com.example.myapplication.domain

import com.example.myapplication.data.FirebaseConnector
import com.example.myapplication.domain.models.InventoryItem
import com.example.myapplication.domain.models.toInventoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InventoryItemRepositoryImpl(
    private val remoteDataSource: FirebaseConnector
) : InventoryItemRepository {

    private val _inventoryItems = MutableStateFlow<List<InventoryItem>>(listOf())
    override val inventoryItems = _inventoryItems.asStateFlow()

    override fun getInventoryItems() {
        _inventoryItems.value = remoteDataSource.getInventoryItems().map(::toInventoryItem)
    }
}
