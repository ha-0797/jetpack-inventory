package com.example.myapplication.presentation.ui.inventoryList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.models.InventoryItem

@Composable
fun InventoryListScreen(state: InventoryListState) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(state.listItems) { item ->
            InventoryListItem(item)
        }
    }
}

class InventoryItemProvider : PreviewParameterProvider<InventoryItem> {
    override val values: Sequence<InventoryItem> =
        listOf(InventoryItem("", false, 1, "", 0)).asSequence()
}

@Preview
@Composable
private fun InventoryListItem(
    @PreviewParameter(InventoryItemProvider::class) item: InventoryItem
) = Card(Modifier.padding(vertical = 8.dp)) {
    Row(Modifier.padding(8.dp)) {
        NameAndBrand(item)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = item.quantity.toString(),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun NameAndBrand(item: InventoryItem) = Column {
    Text(
        text = item.name,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Text(
        text = item.brand,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}