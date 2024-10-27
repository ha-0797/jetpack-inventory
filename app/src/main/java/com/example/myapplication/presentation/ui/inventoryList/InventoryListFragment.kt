package com.example.myapplication.presentation.ui.inventoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.presentation.utilities.composableContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryListFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: InventoryListViewModel by viewModels()

    private val callbacks = object : InventoryListScreenInterface {
        override fun onPullToRefresh() { viewModel.getInventoryItems() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = composableContent {
        val state = viewModel.state.collectAsState(InventoryListState())
        InventoryListScreen(state.value, callbacks)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getInventoryItems()
    }
}
