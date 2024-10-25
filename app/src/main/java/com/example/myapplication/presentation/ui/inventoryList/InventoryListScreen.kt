package com.example.myapplication.presentation.ui.inventoryList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InventoryListScreen(state: InventoryListState) {
    val listState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(listState)
    ) {
        items(state.listItems) {
            InventoryListItem()
        }
    }
}

@Preview
@Composable
private fun InventoryListItem() = Card(Modifier.padding(vertical = 8.dp)) {
    Row(Modifier.padding(8.dp)) {
        Column {
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
            text = "Current Quantity",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}