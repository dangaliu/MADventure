package com.example.madventure.composable.screen.authorization.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madventure.model.AuthorizationModel
import com.example.madventure.model.dto.authorization.LoginModel
import kotlinx.coroutines.launch
import kotlin.math.log

class AuthorizationViewModel(
    private val authorizationModel: AuthorizationModel
): ViewModel() {

    var token = MutableLiveData<String>()

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
}