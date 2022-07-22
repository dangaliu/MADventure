package com.example.madventure.composable.component

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.madventure.R
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.composable.screen.authorization.viewmodel.ScreenState
import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.navigation.NavConstants
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun Authorization(
    vm: AuthorizationViewModel,
    navController: NavHostController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    Spacer(modifier = Modifier.height(61.dp))
    MadventureTextField(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        value = email,
        onValueChange = {
            email = it
        }
    )
    Spacer(modifier = Modifier.height(45.dp))
    MadventureTextField(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        isPassword = true,
        placeholder = "Password",
        value = password,
        onValueChange = {
            password = it
        }
    )
    Spacer(modifier = Modifier.height(45.dp))
    MadventureButton(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        text = "Sign in",
        onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                vm.login(LoginModel(email = email, password = password))
                Toast.makeText(context, "Вы успешно вошли в систему", Toast.LENGTH_SHORT).show()
                navController.navigate(NavConstants.main)
            } else Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
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
        style = onBoardingBtn,
        modifier = Modifier.clickable {
            vm.changeScreenType(ScreenState.REGISTRATION)
        }
    )
}