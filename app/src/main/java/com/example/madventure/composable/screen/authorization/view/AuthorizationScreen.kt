package com.example.madventure.composable.screen.authorization.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.madventure.R
import com.example.madventure.composable.component.MainBox
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel

@Composable
fun AuthorizationScreen(
    navController: NavHostController,
    vm: AuthorizationViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_map),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        MainBox(vm = vm, navHostController = navController)
    }
}