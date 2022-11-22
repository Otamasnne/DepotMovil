package com.example.dappandroid.ui

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

        disableAutofill();

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

    @TargetApi(Build.VERSION_CODES.O)
    private fun disableAutofill() {
        window.decorView.importantForAutofill = View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS
    }
}