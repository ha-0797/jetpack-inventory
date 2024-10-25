package com.example.myapplication.presentation.ui.inventoryList

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.InventoryItemRepository
import com.example.myapplication.domain.di.DomainModule
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InventoryListViewModel @Inject constructor() : ViewModel() {

    private var firebaseConnector: InventoryItemRepository =
        DomainModule.provideInventoryItemRepository()

    fun foo() {
        firebaseConnector.getInventoryItems()
    }
}
