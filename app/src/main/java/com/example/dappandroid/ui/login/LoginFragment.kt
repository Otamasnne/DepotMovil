package com.example.dappandroid.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.dappandroid.R
import com.example.dappandroid.data.network.Resource


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private  lateinit var factory: LoginViewModelFactory
    //private val viewModel: LoginViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Sucess -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_LONG).show()
                }
            }
        })

       val btnIngresar = view.findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener{

            val username = view.findViewById<EditText>(R.id.etUser).text.toString().trim()
            val password = view.findViewById<EditText>(R.id.etPassword).text.toString().trim()
            viewModel.login(username, password)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }


    }

}