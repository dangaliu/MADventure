package com.example.madventure.composable.screen.authorization.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madventure.model.ActivationModel
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.model.dto.SmsCodeModel
import com.example.madventure.model.dto.authorization.LoginModel
import kotlinx.coroutines.launch
import kotlin.math.log

class AuthorizationViewModel(
    private val authorizationModel: AuthorizationModel
) : ViewModel() {

    var token = MutableLiveData<String>()
    var timerValue = MutableLiveData<Long>()

    var type: MutableState<ScreenState> = mutableStateOf(ScreenState.REGISTRATION)

    fun changeScreenType(newType: ScreenState) {
        type.value = newType
    }

    fun login(model: LoginModel) {
        viewModelScope.launch {
            val response = authorizationModel.login(model)

            if (response.isSuccessful) {
                token.value = response.body()?.token
                Log.d("login", token.value.toString())
            } else {
                Log.d("login", response.code().toString())
            }
        }
    }

    fun startTimer() {
        object : CountDownTimer(300000, 1000) {
            override fun onTick(p0: Long) {
                timerValue.value = (p0 / 1000)
            }

            override fun onFinish() {

            }
        }.start()
    }

    fun smsCode(model: SmsCodeModel) {
        viewModelScope.launch {
            val response = authorizationModel.smsCode(model)
            if (response.isSuccessful) {
                Log.d("smsCode", response.code().toString())
            } else {
                Log.d("smsCode", response.code().toString() + response.message())
            }
        }
    }

    fun activation(model: ActivationModel) {
        viewModelScope.launch {
            var response = authorizationModel.activation(model)
            if (response.isSuccessful) {
                Log.d("activation", response.code().toString())
            } else Log.d("activation", response.code().toString() + response.message())
        }
    }

}

enum class ScreenState {
    AUTHORIZATION, REGISTRATION, ACTIVATION
}