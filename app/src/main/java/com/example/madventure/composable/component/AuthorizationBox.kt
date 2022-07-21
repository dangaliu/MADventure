package com.example.madventure.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.madventure.R
import com.example.madventure.ui.theme.AppGray
import com.example.madventure.ui.theme.AppGrayDark
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun AuthorizationBox(
    modifier: Modifier = Modifier
        .width(650.dp)
        .height(637.dp)
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = AppGrayDark
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 40.dp, horizontal = 98.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash_logo),
                contentDescription = "logo",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(61.dp))
            MadventureTextField(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),

                )
            Spacer(modifier = Modifier.height(45.dp))
            MadventureTextField(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                isPassword = true,
                placeholder = "Password",
            )
            Spacer(modifier = Modifier.height(45.dp))
            MadventureButton(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                text = "Sign in",
                onClick = {

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
    }
}