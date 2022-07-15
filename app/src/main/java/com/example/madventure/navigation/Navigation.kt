package com.example.madventure.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.madventure.composable.screen.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.splash
    ) {
        composable(route = NavConstants.splash) {
            SplashScreen(navController = navController)
        }
    }
}