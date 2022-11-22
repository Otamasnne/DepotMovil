package com.example.dappandroid.ui.login

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
import androidx.viewbinding.ViewBinding
import com.example.dappandroid.R


class LoginFragment : Fragment() {

//    private lateinit var viewModel: LoginViewModel
    private val viewModel: LoginViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       val btnIngresar = view.findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener{


            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }


    }

}