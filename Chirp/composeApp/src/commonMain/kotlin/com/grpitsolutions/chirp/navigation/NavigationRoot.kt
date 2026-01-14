package com.grpitsolutions.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.grpitsolutions.auth.presentation.navigation.AuthGraphRoutes
import com.grpitsolutions.auth.presentation.navigation.authGraph
import com.grpitsolutions.chat.presentation.chat_list.ChatListRoute
import com.grpitsolutions.chat.presentation.chat_list.ChatListScreenRoot


@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraphRoutes.Graph
    ) {
        authGraph(
            navController = navController,
            onLoginSuccess = {
                navController.navigate(ChatListRoute) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )
        composable<ChatListRoute> {
            ChatListScreenRoot()
        }
    }
}