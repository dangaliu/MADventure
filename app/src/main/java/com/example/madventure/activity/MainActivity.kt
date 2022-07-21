package com.example.madventure.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationFactory
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.composable.screen.onboarding.viewmodel.OnBoardingViewModel
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.navigation.Navigation
import com.example.madventure.ui.theme.MADventureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADventureTheme {
                App()
            }
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun App() {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val context = LocalContext.current

        val onBoardingViewModel = ViewModelProvider(this)[OnBoardingViewModel::class.java]

        val authorizationModel = AuthorizationModel()
        val authorizationFactory = AuthorizationFactory(authorizationModel)
        val authorizationViewModel = ViewModelProvider(this, authorizationFactory)[AuthorizationViewModel::class.java]

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            scaffoldState = scaffoldState
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(bottom = paddingValues.calculateBottomPadding())
                    .fillMaxSize()
            ) {
                Navigation(
                    navController = navController,
                    onBoardingViewModel = onBoardingViewModel,
                    authorizationViewModel = authorizationViewModel
                )
            }
        }
    }
}
