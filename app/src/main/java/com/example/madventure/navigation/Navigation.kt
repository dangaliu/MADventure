package com.example.madventure.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.madventure.composable.screen.SplashScreen
import com.example.madventure.composable.screen.authorization.view.AuthorizationScreen
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.composable.screen.main.view.MainScreen
import com.example.madventure.composable.screen.onboarding.view.OnBoardingScreen
import com.example.madventure.composable.screen.onboarding.viewmodel.OnBoardingViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel,
    authorizationViewModel: AuthorizationViewModel
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
        composable(route = NavConstants.authorization) {
            AuthorizationScreen(
                navController = navController,
                authorizationViewModel
            )
        }
        composable(route = NavConstants.main) {
            MainScreen(
                navController = navController
            )
        }
    }
}