package com.example.myapplication.presentation.ui.inventoryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.presentation.utilities.composableContent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InventoryListFragment : Fragment(R.layout.fragment_first) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = composableContent(false) {
        InventoryListScreen()
    }
}