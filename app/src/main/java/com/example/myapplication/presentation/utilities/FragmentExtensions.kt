package com.example.myapplication.presentation.utilities

import android.view.ViewGroup
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

fun Fragment.composableContent(
    isLightTheme: Boolean,
    content: @Composable () -> Unit
) = ComposeView(requireContext()).apply {
    setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
    layoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
    setContent {
        Theme(content, isLightTheme)
    }
}

typealias AndroidAttr = android.R.attr
typealias MaterialAttr = com.google.android.material.R.attr

@Composable
private fun Theme(
    content: @Composable () -> Unit,
    isLightTheme: Boolean
) = MaterialTheme(
    colors = themeColourScheme(isLightTheme),
    content = content
)

@Composable
private fun themeColourScheme(isLightTheme: Boolean) = Colors(
    primary = Color(LocalContext.current.colorAttribute(MaterialAttr.colorPrimary)),
    onPrimary = Color(LocalContext.current.colorAttribute(MaterialAttr.colorOnPrimary)),
    primaryVariant = Color(LocalContext.current.colorAttribute(MaterialAttr.colorPrimaryVariant)),
    secondary = Color(LocalContext.current.colorAttribute(MaterialAttr.colorSecondary)),
    onSecondary = Color(LocalContext.current.colorAttribute(MaterialAttr.colorOnSecondary)),
    secondaryVariant = Color(LocalContext.current.colorAttribute(MaterialAttr.colorSecondaryVariant)),
    background = Color(LocalContext.current.colorAttribute(AndroidAttr.windowBackground)),
    onBackground = Color(LocalContext.current.colorAttribute(AndroidAttr.windowBackground)),
    surface = Color(LocalContext.current.colorAttribute(MaterialAttr.colorSurface)),
    onSurface = Color(LocalContext.current.colorAttribute(MaterialAttr.colorOnSurface)),
    error = Color(LocalContext.current.colorAttribute(MaterialAttr.colorError)),
    onError = Color(LocalContext.current.colorAttribute(MaterialAttr.colorOnError)),
    isLight = isLightTheme
)


