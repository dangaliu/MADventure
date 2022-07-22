package com.example.madventure.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.madventure.R
import com.example.madventure.composable.screen.authorization.viewmodel.AuthorizationViewModel
import com.example.madventure.composable.screen.authorization.viewmodel.ScreenState
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.ui.theme.AppGray
import com.example.madventure.ui.theme.AppGrayDark
import com.example.madventure.ui.theme.onBoardingBtn

@Composable
fun MainBox(
    modifier: Modifier = Modifier
        .width(650.dp),
    vm: AuthorizationViewModel
) {
    Surface(
        modifier = modifier.height(
            when (vm.type.value) {
                ScreenState.AUTHORIZATION -> 710.dp
                ScreenState.REGISTRATION -> 760.dp
                ScreenState.ACTIVATION -> 485.dp
                else -> 0.dp
            }
        ),
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
            when (vm.type.value) {
                ScreenState.AUTHORIZATION -> Authorization(vm = vm)
                ScreenState.REGISTRATION -> Registration(vm)
                ScreenState.ACTIVATION -> Activation("", vm)
                else -> null
            }

        }
    }
}