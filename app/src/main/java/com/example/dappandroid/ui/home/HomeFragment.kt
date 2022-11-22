package com.example.dappandroid.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dappandroid.R
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.data.network.PedidosApi
import com.example.dappandroid.data.repositories.PedidosRepository
import com.example.dappandroid.databinding.FragmentHomeBinding
import com.example.dappandroid.ui.pedidos.PedidosViewModel
import com.example.dappandroid.ui.pedidos.PedidosViewModelFactory

class HomeFragment (): Fragment() {


    //private lateinit var viewModel: HomeViewModel
    private lateinit var viewModel: HomeViewModel
    private lateinit var factory: HomeViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEgresos = view.findViewById<Button>(R.id.botonEgresos)
        val api = PedidosApi()
        val repository = PedidosRepository(api)

        factory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        //viewModel = ViewModelProviders.of(this, factory).get(PedidosViewModel::class.java)
        viewModel.getPedidos()


        val pedidos = viewModel.pedidos.value?.size.toString()

        btnEgresos.text = pedidos


        btnEgresos.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_pedidosFragment)
        }


    }

}