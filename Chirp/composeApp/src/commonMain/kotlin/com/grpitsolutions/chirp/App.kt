package com.grpitsolutions.chirp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.grpitsolutions.chirp.navigation.DeepLinkListener
import com.grpitsolutions.chirp.navigation.NavigationRoot
import com.grpitsolutions.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    DeepLinkListener(navController)
    ChirpTheme {
        NavigationRoot(navController)
    }
}