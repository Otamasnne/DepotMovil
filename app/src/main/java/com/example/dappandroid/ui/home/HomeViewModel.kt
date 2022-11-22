package com.example.dappandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.data.repositories.PedidosRepository
import com.example.dappandroid.util.Coroutines
import kotlinx.coroutines.Job

class HomeViewModel (
    private val repository: PedidosRepository
        ): ViewModel() {

    private lateinit var job: Job

    //No debemos exponser mutableLiveData por fuera de la clase
    private val _pedidos = MutableLiveData<List<PedidosResponseItem>>()

    //Live Data que va a ser expuesta por fuera de la clase pero que no puede ser cambiada
    val pedidos : LiveData<List<PedidosResponseItem>>
        get() = _pedidos


    fun getPedidos() {

        job = Coroutines.ioThenMain(
            { repository.getPedidos() },
            { _pedidos.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}