package com.example.dappandroid.data.repositories

import android.service.autofill.UserData
import com.example.dappandroid.data.models.user.User
import com.example.dappandroid.data.models.user.UserBody
import com.example.dappandroid.data.models.user.userDos
import com.example.dappandroid.data.network.PedidosApi
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit

class LoginRepository (private val api: PedidosApi): SafeApiRequest() {

    suspend fun login(userData: userDos) = api.login(userData)
    //suspend fun login(userData: UserBody) = apiRequest { api.login(userData) }
//    suspend fun login(userData: UserBody): Response<User>{
//        return api.login(userData)
//    }
}