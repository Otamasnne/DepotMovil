package com.example.dappandroid.data.repositories

import com.example.dappandroid.data.network.PedidosApi

class DetalleRepository (private val api: PedidosApi): SafeApiRequest() {

    //CAMBIO -> apiRequest -> safeApiCall
    suspend fun getArticulos() = safeApiCall { api.getArticulos() }
}