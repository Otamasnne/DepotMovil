package com.example.dappandroid.ui.detalle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dappandroid.R
import com.example.dappandroid.data.network.PedidosApi
import com.example.dappandroid.data.repositories.DetalleRepository

class DetalleFragment : Fragment() {

    var recycler: RecyclerView? = null

    private lateinit var factory: DetalleViewModelFactory
    private lateinit var viewModel: DetalleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = PedidosApi()
        val repository = DetalleRepository(api)
        recycler = view.findViewById(R.id.recycler_view_detalle)

        //seguir

        factory = DetalleViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[DetalleViewModel::class.java]
//        viewModel.getArticulos()
//        viewModel.articulos.observe(viewLifecycleOwner, Observer { articulos ->
//
//            recycler.also {
//                it?.layoutManager = LinearLayoutManager(requireContext())
//                it?.setHasFixedSize(true)
//                it?.adapter = DetalleAdapter(articulos)
//            }
//
//        })

    }
}