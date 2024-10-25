package com.example.myapplication.data

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class FirebaseConnectorImpl @Inject constructor(private val firestore: FirebaseFirestore) :
    FirebaseConnector {
    override fun getInventoryItems() {
        firestore.collection("/ShoppingItems").get().addOnSuccessListener {
        }.addOnFailureListener {
        }
    }
}