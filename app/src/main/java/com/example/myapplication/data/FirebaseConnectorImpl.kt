package com.example.myapplication.data

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FirebaseConnectorImpl(): FirebaseConnector {
    override fun getInventoryItems() {
        val firestore = Firebase.firestore
        firestore.collection("/ShoppingItems").get().addOnSuccessListener {
        }.addOnFailureListener {
        }
    }
}