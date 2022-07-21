package com.example.madventure.composable.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madventure.R
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun Authorization(
    vm: AuthorizationViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Spacer(modifier = Modifier.height(61.dp))
    MadventureTextField(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        value = email
    )
    Spacer(modifier = Modifier.height(45.dp))
    MadventureTextField(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        isPassword = true,
        placeholder = "Password",
        value = password
    )
    Spacer(modifier = Modifier.height(45.dp))
    MadventureButton(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        text = "Sign in",
        onClick = {
            vm.login(LoginModel(email = email, password = password))
        }
    )
    Spacer(modifier = Modifier.height(45.dp))
    MadventureButton(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        text = "Sign in with Facebook",
        icon = R.drawable.facebook_logo,
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(66.dp))
    Text(
        text = "Sign up",
        style = onBoardingBtn
    )
}