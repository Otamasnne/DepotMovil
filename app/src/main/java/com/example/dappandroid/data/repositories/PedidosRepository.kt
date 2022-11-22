package com.example.dappandroid.data.repositories

import com.example.dappandroid.data.network.PedidosApi

class PedidosRepository (private val api: PedidosApi) : SafeApiRequest() {

    suspend fun getPedidos() = apiRequest { api.getPedidos() }

}