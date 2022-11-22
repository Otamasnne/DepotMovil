package com.example.dappandroid.ui.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dappandroid.data.repositories.DetalleRepository
import com.example.dappandroid.ui.pedidos.PedidosViewModel

@Suppress("UNCHECKED_CAST")
class DetalleViewModelFactory (
    private val repository: DetalleRepository
        ) : ViewModelProvider.NewInstanceFactory() {

            override fun <T: ViewModel> create(modelClass: Class<T>): T {
                return DetalleViewModel(repository) as T
            }
}