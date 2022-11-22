package com.example.dappandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dappandroid.data.models.user.User
import com.example.dappandroid.data.network.Resource
import com.example.dappandroid.data.repositories.LoginRepository
import com.example.dappandroid.util.Coroutines
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: LoginRepository
        ) : ViewModel() {

    private val _loginResponse = MutableLiveData< Resource<User>>()

    val loginResponse : LiveData<Resource<User>>
        get() = _loginResponse

    fun login(
        username: String,
        password: String
    ) = viewModelScope.launch{
        _loginResponse.value = repository.login(username,password)
    }

//    fun login(username: String, password: String) {
//        job = Coroutines.ioThenMain(
//            { repository.login(username, password)},
//            {_user.value = it}
//        )
//    }

//    override fun onCleared() {
//        super.onCleared()
//        if(::job.isInitialized) job.cancel()
//    }





}