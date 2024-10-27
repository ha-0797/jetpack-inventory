package com.example.myapplication.presentation.utilities

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> Flow<T>.observe(
    activity: AppCompatActivity,
    action: suspend (T) -> Unit
) = activity.lifecycleScope.launch {
    activity.repeatOnLifecycle(Lifecycle.State.STARTED) {
        collect(action)
    }
}
