package com.example.myapplication.domain.models

import com.example.myapplication.data.models.InventoryItemResponse

data class InventoryItem(
    val brand: String,
    val ignore: Boolean,
    val minRequired: Int,
    val name: String,
    val quantity: Int
)

fun toInventoryItem(result: InventoryItemResponse) = InventoryItem(
    brand = result.brand.orEmpty(),
    ignore = result.ignore ?: true,
    minRequired = result.minRequired ?: 1,
    name = result.name.orEmpty(),
    quantity = result.quantity ?: 0
)
