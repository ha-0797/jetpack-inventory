package com.example.myapplication.presentation.ui.newItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.presentation.utilities.composableContent

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewItemFragment : Fragment(R.layout.fragment_new_item) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = composableContent {  }
}
