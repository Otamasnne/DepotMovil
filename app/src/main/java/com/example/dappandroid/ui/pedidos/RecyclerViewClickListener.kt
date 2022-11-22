package com.example.dappandroid.ui.pedidos

import android.view.View
import com.example.dappandroid.data.models.PedidosResponseItem

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, pedido: PedidosResponseItem){

    }
}