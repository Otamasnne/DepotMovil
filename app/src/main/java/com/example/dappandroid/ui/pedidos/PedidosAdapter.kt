package com.example.dappandroid.ui.pedidos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dappandroid.R
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.databinding.RecyclerviewPedidoBinding

class PedidosAdapter (
    private val pedidos: List<PedidosResponseItem>,
    private val listener: RecyclerViewClickListener
        ) : RecyclerView.Adapter<PedidosAdapter.PedidosViewHolder>(){


    //Esta funcion nos va a decir el tamanio de nuestra lista
    override fun getItemCount() = pedidos.size

    //Esta funcion nos crea y retorna un pedido view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PedidosViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_pedido,
            parent,
            false
        )
    )


    //Esta funcion bind la data al view holder
    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
        holder.recyclerviewPedidoBinding.pedido = pedidos[position]
        holder.recyclerviewPedidoBinding.root.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewPedidoBinding.root, pedidos[position])
        }
//        val currentItem = pedidos[position]
//        holder.recyclerviewPedidoBinding.pedidoCodigo.text = currentItem.codigo

    }

    inner class PedidosViewHolder(
        val recyclerviewPedidoBinding: RecyclerviewPedidoBinding
    ) : RecyclerView.ViewHolder(recyclerviewPedidoBinding.root)

}