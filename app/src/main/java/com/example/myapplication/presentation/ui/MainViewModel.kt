package com.example.myapplication.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.presentation.ui.MainEvents.NewItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class MainEvents {
    data object NewItem : MainEvents()
}

fun mainEventsCallbacks(
    events: MainEvents,
    newItemCallback: Unit
) = when (events) {
    NewItem -> newItemCallback
    else -> {}
}

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _events = MutableSharedFlow<MainEvents>()
    val events = _events.asSharedFlow()

    fun openAddItemBottomSheet() {
        viewModelScope.launch {
            _events.emit(MainEvents.NewItem)
        }
    }
}
