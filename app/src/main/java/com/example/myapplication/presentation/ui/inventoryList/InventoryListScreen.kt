package com.example.myapplication.presentation.ui.inventoryList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InventoryListScreen() = Column(
    modifier = Modifier.padding(16.dp)
) {
    InventoryListItem()
}

@Preview
@Composable
private fun InventoryListItem() = Card {
    Row {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "Item name",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Item brand",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Current Quantity",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}