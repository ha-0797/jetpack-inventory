package com.example.myapplication.data

import com.example.myapplication.data.models.InventoryItemResponse

interface FirebaseConnector {
    suspend fun getInventoryItems(): List<InventoryItemResponse>
}
