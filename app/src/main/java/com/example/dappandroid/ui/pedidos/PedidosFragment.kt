package com.example.dappandroid.ui.pedidos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dappandroid.R
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.data.network.PedidosApi
import com.example.dappandroid.data.repositories.PedidosRepository


class PedidosFragment : Fragment(R.layout.fragment_pedidos), RecyclerViewClickListener {

    var recycler: RecyclerView? = null

    private lateinit var factory: PedidosViewModelFactory
    private lateinit var viewModel: PedidosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_pedidos, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = PedidosApi()
        val repository = PedidosRepository(api)
        recycler = view.findViewById(R.id.recycler_view_pedidos)

        factory = PedidosViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[PedidosViewModel::class.java]
        //viewModel = ViewModelProviders.of(this, factory).get(PedidosViewModel::class.java)
        viewModel.getPedidos()
        viewModel.pedidos.observe(viewLifecycleOwner, Observer { pedidos ->

            recycler.also {
                it?.layoutManager = LinearLayoutManager(requireContext())
                it?.setHasFixedSize(true)
                it?.adapter = PedidosAdapter(pedidos, this)

            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, pedido: PedidosResponseItem) {
        super.onRecyclerViewItemClick(view, pedido)

        Toast.makeText(requireContext(), "clickwork", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_pedidosFragment_to_detalleFragment)

    }

    /*algunas cosas deprecadas*/
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        val api = PedidosApi()
//        val repository = PedidosRepository(api)
//        recycler = view?.findViewById(R.id.recycler_view_pedidos)
//
//        factory = PedidosViewModelFactory(repository)
//        //viewModel = ViewModelProvider(this, factory)[PedidosViewModel::class.java]
//        viewModel = ViewModelProviders.of(this, factory).get(PedidosViewModel::class.java)
//        viewModel.getPedidos()
//        viewModel.pedidos.observe(viewLifecycleOwner, Observer { pedidos ->
//
//            recycler.also {
//                it?.layoutManager = LinearLayoutManager(requireContext())
//                it?.setHasFixedSize(true)
//                it?.adapter = PedidosAdapter(pedidos)
//
//            }
//        })
//
//    }






}