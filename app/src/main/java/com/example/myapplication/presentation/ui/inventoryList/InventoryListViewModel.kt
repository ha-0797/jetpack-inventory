package com.example.myapplication.presentation.ui.inventoryList

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.FirebaseConnectorImpl

class InventoryListViewModel: ViewModel() {

    private val firebaseConnector = FirebaseConnectorImpl()

    fun foo() {
        firebaseConnector.getInventoryItems()
    }
}