package com.example.myapplication.data.models

import com.google.firebase.firestore.DocumentSnapshot

data class InventoryItemResponse(
    val brand: String?,
    val ignore: Boolean?,
    val minRequired: Int?,
    val name: String?,
    val quantity: Int?
)

fun toInventoryItemResponse(document: DocumentSnapshot) = InventoryItemResponse(
    brand = document.getString("brand"),
    ignore = document.getBoolean("ignore"),
    minRequired = document.getDouble("min_required")?.toInt(),
    name = document.getString("name"),
    quantity = document.getDouble("quantity")?.toInt()
)
