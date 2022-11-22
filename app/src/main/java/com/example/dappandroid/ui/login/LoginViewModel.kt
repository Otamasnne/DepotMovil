package com.example.dappandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dappandroid.data.models.user.User
import com.example.dappandroid.data.repositories.LoginRepository
import com.example.dappandroid.util.Coroutines

class LoginViewModel (
    private val repository: LoginRepository
        ) : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user : LiveData<User>
        get() = _user

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