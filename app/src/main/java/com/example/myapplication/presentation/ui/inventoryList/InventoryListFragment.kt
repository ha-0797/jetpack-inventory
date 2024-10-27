package com.example.myapplication.presentation.ui.inventoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.presentation.utilities.composableContent
import com.example.myapplication.presentation.utilities.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryListFragment : Fragment(R.layout.fragment_inventory_list) {

    private val viewModel: InventoryListViewModel by viewModels()

    private val callbacks = object : InventoryListScreenInterface {
        override fun onPullToRefresh() = viewModel.getInventoryItems()

        override fun onFABClicked() = viewModel.openNewItemFragment()
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
        viewModel.events.observe(this, ::observeEvents)
    }

    private fun observeEvents(events: InventoryListEvents) =
        inventoryListEventsCallbacks(events, navigateToNewItem())

    private fun navigateToNewItem() =
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
}
