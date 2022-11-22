package com.example.dappandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dappandroid.data.repositories.PedidosRepository
import com.example.dappandroid.ui.pedidos.PedidosViewModel

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory (
    private val repository: PedidosRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}