package com.grpitsolutions.chirp

import androidx.compose.runtime.Composable
import com.grpitsolutions.chirp.navigation.NavigationRoot
import com.grpitsolutions.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ChirpTheme {
        NavigationRoot()
    }
}