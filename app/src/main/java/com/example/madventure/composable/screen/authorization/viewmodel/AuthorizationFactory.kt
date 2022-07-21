package com.example.madventure.composable.screen.authorization.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.madventure.model.AuthorizationModel

class AuthorizationFactory(
    private val authorizationModel: AuthorizationModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthorizationViewModel(authorizationModel) as T
    }
}