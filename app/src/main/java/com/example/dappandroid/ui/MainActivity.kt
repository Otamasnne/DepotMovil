package com.example.dappandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dappandroid.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


//        val repository = PedidosRepository(PedidosApi())


//
//        GlobalScope.launch(Dispatchers.Main) {
//            val pedidos = repository.getPedidos()
//
//            Toast.makeText(this@MainActivity, pedidos.toString(), Toast.LENGTH_LONG).show()
//        }

        //        val navHostController = supportFragmentManager
//            .findFragmentById(R.id.nav_host_fragment)


    }
}