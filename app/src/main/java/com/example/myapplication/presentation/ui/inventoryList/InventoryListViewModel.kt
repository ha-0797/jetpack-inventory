package com.example.myapplication.presentation.ui.inventoryList

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.FirebaseConnector
import com.example.myapplication.data.FirebaseConnectorImpl
import com.example.myapplication.data.di.RemoteDataModule
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InventoryListViewModel @Inject constructor() : ViewModel() {

    private var firebaseConnector: FirebaseConnector =
        RemoteDataModule.provideFirebaseConnector()

    fun foo() {
        firebaseConnector.getInventoryItems()
    }
}