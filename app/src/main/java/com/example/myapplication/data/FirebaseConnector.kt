package com.example.myapplication.data

import com.example.myapplication.data.models.InventoryItemResponse

interface FirebaseConnector {
    fun getInventoryItems(): List<InventoryItemResponse>
}
