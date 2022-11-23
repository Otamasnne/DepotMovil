package com.example.dappandroid.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.service.autofill.UserData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.dappandroid.R
import com.example.dappandroid.data.models.user.*
import com.example.dappandroid.data.network.PedidosApi
import com.example.dappandroid.data.network.Resource
import com.example.dappandroid.data.repositories.LoginRepository
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response


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


        val api = PedidosApi()
        val repository = LoginRepository(api)

        factory = LoginViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

//                viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
//            when(it){
//                is Resource.Sucess -> {
//                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
//                }
//                is Resource.Failure -> {
//                    Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_LONG).show()
//                }
//            }
//        })

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            if(it.password contentEquals "1234" ){
                //Toast.makeText(requireContext(), "casi", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }else{
                Toast.makeText(requireContext(), "Login Failure", Toast.LENGTH_LONG).show()
            }

        })


       val btnIngresar = view.findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener{

            val usernameFrom = view.findViewById<EditText>(R.id.etUser).text.toString().trim()
            val passwordFrom = view.findViewById<EditText>(R.id.etPassword).text.toString().trim()

//            val jsonObject = JSONObject()
//            jsonObject.put("username", usernameFrom)
//            jsonObject.put("password", passwordFrom)
//
            //val userData = UserBody (jsonObject)
//            val jsonObjectString = jsonObject.toString()

//            val userData = UserBody (
//               username = usernameFrom,
//                password = passwordFrom
//            )

            val username = Username(usernameFrom)
            val password = Password(passwordFrom)
            val userData = userDos(password,username)

            //val userData = jsonObject
            viewModel.login(userData)


//            Toast.makeText(requireContext(), usernameFrom, Toast.LENGTH_LONG).show()
//            Toast.makeText(requireContext(), passwordFrom, Toast.LENGTH_LONG).show()

        }


    }

}