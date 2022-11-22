package com.example.dappandroid.data.repositories

import com.example.dappandroid.data.network.PedidosApi

class LoginRepository (private val api: PedidosApi): SafeApiRequest() {

    suspend fun login(
        username: String,
        password: String
    ) = safeApiCall { api.login(username, password) }
}