package com.example.madventure.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.madventure.composable.screen.SplashScreen
import com.example.madventure.composable.screen.onboarding.view.OnBoardingScreen
import com.example.madventure.composable.screen.onboarding.viewmodel.OnBoardingViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.splash
    ) {
        composable(route = NavConstants.splash) {
            SplashScreen(navController = navController)
        }
        composable(route = NavConstants.onboarding) {
            OnBoardingScreen(
                navController = navController,
                vm = onBoardingViewModel
            )
        }
    }
}