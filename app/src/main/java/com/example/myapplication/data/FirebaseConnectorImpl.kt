package com.example.myapplication.data

import com.example.myapplication.data.models.toInventoryItemResponse
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseConnectorImpl @Inject constructor(private val firestore: FirebaseFirestore) :
    FirebaseConnector {

    override fun getInventoryItems() = firestore.collection("ShoppingItems").get()
        .result.documents.map(::toInventoryItemResponse)
}
