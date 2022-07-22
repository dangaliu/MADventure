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
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.ui.theme.AppGray
import com.example.madventure.ui.theme.AppGrayDark
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun MainBox(
    modifier: Modifier = Modifier
        .width(650.dp)
//        .height(637.dp),
//        .height(760.dp),
        .height(485.dp),
    vm: AuthorizationViewModel
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
//            Authorization(vm = vm)
//            Registration()
            Activation()
        }
    }
}