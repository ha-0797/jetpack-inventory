package com.example.myapplication.presentation.utilities

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat

fun Context.colorAttribute(@AttrRes id: Int): Int {
    val resolvedAttr = TypedValue()
    theme.resolveAttribute(id, resolvedAttr, true)
    return ContextCompat.getColor(this, resolvedAttr.resourceId)
}
