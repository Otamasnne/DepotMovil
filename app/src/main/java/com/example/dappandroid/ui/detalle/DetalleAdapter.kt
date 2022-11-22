package com.example.dappandroid.ui.detalle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dappandroid.R
import com.example.dappandroid.data.models.ArticuloItem
import com.example.dappandroid.data.models.ArticuloX
import com.example.dappandroid.data.models.detalle.Value
import com.example.dappandroid.databinding.RecyclerviewDetalleBinding

class DetalleAdapter (
    private val articulos: List<Value>
        ) : RecyclerView.Adapter<DetalleAdapter.DetalleViewHolder>(){

    override fun getItemCount() = articulos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetalleViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_pedido,
            parent,
            false
        )
            )

    override fun onBindViewHolder(holder: DetalleViewHolder, position: Int) {
        holder.recyclerviewDetalleBinding.articulo = articulos[position]

    }

    inner class DetalleViewHolder(
        val recyclerviewDetalleBinding: RecyclerviewDetalleBinding
    ) : RecyclerView.ViewHolder(recyclerviewDetalleBinding.root)
}