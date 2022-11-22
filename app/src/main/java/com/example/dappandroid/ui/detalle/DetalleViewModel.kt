package com.example.dappandroid.ui.detalle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dappandroid.data.models.detalle.Value
import com.example.dappandroid.data.repositories.DetalleRepository
import com.example.dappandroid.util.Coroutines
import kotlinx.coroutines.Job

class DetalleViewModel (
    private val repository: DetalleRepository
        ) : ViewModel() {

        private lateinit var job: Job

        private val _articulos = MutableLiveData<List<Value>>()

        val articulos : LiveData<List<Value>>
            get() = _articulos;

        fun getArticulos() {

            job = Coroutines.ioThenMain(
                { repository.getArticulos()},
                {_articulos.value = it}
            )
        }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}