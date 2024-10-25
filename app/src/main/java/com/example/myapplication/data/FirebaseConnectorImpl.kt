package com.example.myapplication.data

import com.example.myapplication.data.models.toInventoryItemResponse
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseConnectorImpl @Inject constructor(private val firestore: FirebaseFirestore) :
    FirebaseConnector {

    override suspend fun getInventoryItems() = firestore.collection("ShoppingItems")
        .get().await().documents.map(::toInventoryItemResponse)
}
