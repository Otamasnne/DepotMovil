package com.example.dappandroid.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dappandroid.data.repositories.LoginRepository
import com.example.dappandroid.ui.detalle.DetalleViewModel

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory (
    private val repository: LoginRepository
        ) : ViewModelProvider.NewInstanceFactory() {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(repository) as T
            }
}