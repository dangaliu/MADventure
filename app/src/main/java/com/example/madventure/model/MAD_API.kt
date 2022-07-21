package com.example.madventure.model

import com.example.madventure.model.dto.authorization.LoginModel
import com.example.madventure.model.dto.authorization.LoginResponseModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface MAD_API {
    companion object {
        val instance = Retrofit.Builder()
            .baseUrl("http://wsk2019.mad.hakta.pro/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MAD_API::class.java)
    }

    @POST
    suspend fun login(@Body model: LoginModel): Response<LoginResponseModel>
}