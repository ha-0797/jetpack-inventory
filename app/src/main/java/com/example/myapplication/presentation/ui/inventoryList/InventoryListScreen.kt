package com.example.myapplication.presentation.ui.inventoryList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.models.InventoryItem

interface InventoryListScreenInterface {
    fun onPullToRefresh()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InventoryListScreen(state: InventoryListState, callbacks: InventoryListScreenInterface) {
    val pullRefreshState = rememberPullRefreshState(state.isLoading, callbacks::onPullToRefresh)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState, true)
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            state = rememberLazyListState()
        ) {
            items(state.listItems) { item ->
                InventoryListItem(item)
            }
        }
        PullRefreshIndicator(
            modifier = Modifier.align(Alignment.TopCenter),
            refreshing = state.isLoading,
            state = pullRefreshState
        )
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