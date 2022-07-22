package com.example.madventure.model

import com.example.madventure.model.dto.SmsCodeModel
import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.model.dto.authorization.LoginResponseModel
import retrofit2.Response

class AuthorizationModel {

    suspend fun login(model: LoginModel): Response<LoginResponseModel> =
        MainApi.instance.login(model)

    suspend fun smsCode(model: SmsCodeModel): Response<Any> =
        MainApi.instance.smsCode(model)
}