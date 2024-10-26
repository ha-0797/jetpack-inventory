package com.example.myapplication.data

import com.example.myapplication.data.models.toInventoryItemResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseConnectorImpl @Inject constructor() : FirebaseConnector {

    private val firestore = Firebase.firestore

    override suspend fun getInventoryItems() = firestore.collection("ShoppingItems")
        .get().await().documents.map(::toInventoryItemResponse)
}
