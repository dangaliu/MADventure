package com.example.madventure.composable.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.composable.screen.authorization.viewmodel.ScreenState
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.model.dto.SmsCodeModel
import com.example.madventure.ui.theme.Primary
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun Registration(
    viewModel: AuthorizationViewModel
) {
    val email by remember { mutableStateOf("") }
    val nickname by remember { mutableStateOf("") }
    val code by remember { mutableStateOf("") }
    val phone by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }
    val repeatPassword by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(55.dp))
    MadventureTextField(
        value = email,
        placeholder = "Email",
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    MadventureTextField(
        value = nickname,
        placeholder = "Nickname",
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(30.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        MadventureTextField(
            value = code,
            placeholder = "Code",
            modifier = Modifier
                .height(50.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        MadventureTextField(
            value = phone,
            placeholder = "Phone",
            modifier = Modifier
                .height(50.dp)
                .weight(5f)
        )
    }
    Spacer(modifier = Modifier.height(30.dp))
    MadventureTextField(
        value = password,
        placeholder = "Password",
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        isPassword = true
    )
    Spacer(modifier = Modifier.height(30.dp))
    MadventureTextField(
        value = repeatPassword,
        placeholder = "Repeat password",
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        isPassword = true
    )
    Spacer(modifier = Modifier.height(30.dp))
    MadventureButton(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        text = "Sign up",
        onClick = {
            viewModel.smsCode(SmsCodeModel(code, phone))
        }
    )
    Spacer(modifier = Modifier.height(30.dp))
    Text(
        text = "Sign in",
        style = onBoardingBtn.copy(color = Primary),
        modifier = Modifier.clickable {
            viewModel.changeScreenType(ScreenState.AUTHORIZATION)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Registration(AuthorizationViewModel(AuthorizationModel()))
    }
}