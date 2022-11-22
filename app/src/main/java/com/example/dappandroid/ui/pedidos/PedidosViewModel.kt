package com.example.dappandroid.ui.pedidos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dappandroid.util.Coroutines
import com.example.dappandroid.data.repositories.PedidosRepository
import com.example.dappandroid.data.models.PedidosResponseItem
import kotlinx.coroutines.Job

//Este view model se va a comunicar con nuestro pedidosRepository
//Por lo que necesitamos una instancia
class PedidosViewModel(
    private val repository: PedidosRepository
) : ViewModel() {

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

//    suspend fun getPedidos() {
//        val pedidos = repository.getPedidos()
//        _pedidos.value = pedidos
//    }
}