package com.example.myapplication.presentation.ui.inventoryList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun InventoryListScreen() = Column {
    InventoryListItem()
}

@Composable
private fun InventoryListItem() = Row() {
    Text(
        text = "Item name",
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Text(
        text = "Item brand",
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Text(
        text = "Current Quantity",
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}
