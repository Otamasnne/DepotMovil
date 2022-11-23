package com.example.dappandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dappandroid.data.models.user.User
import com.example.dappandroid.data.models.user.UserBody
import com.example.dappandroid.data.models.user.userDos
import com.example.dappandroid.data.network.Resource
import com.example.dappandroid.data.repositories.LoginRepository
import com.example.dappandroid.util.Coroutines
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class LoginViewModel (
    private val repository: LoginRepository
        ) : ViewModel() {

    private lateinit var job: Job

    private val _loginResponse: MutableLiveData<User> = MutableLiveData()
    //private val _loginResponse: MutableLiveData<Resource<User>> = MutableLiveData()

    val loginResponse : LiveData<User>
        get() = _loginResponse

//    val loginResponse : LiveData<Resource<User>>
//        get() = _loginResponse


//    fun login(userData: UserBody) = viewModelScope.launch{
//        _loginResponse.value = repository.login(userData)
//
//    }

    fun login(userData: userDos) {

        job = Coroutines.ioThenMain(
            { repository.login(userData)},
            {_loginResponse.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }





}