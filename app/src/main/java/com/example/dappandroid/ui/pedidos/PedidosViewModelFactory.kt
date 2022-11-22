package com.example.dappandroid.ui.pedidos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dappandroid.data.repositories.PedidosRepository

@Suppress("UNCHECKED_CAST")
class PedidosViewModelFactory (
    private val repository: PedidosRepository
        ) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PedidosViewModel(repository) as T
    }


}