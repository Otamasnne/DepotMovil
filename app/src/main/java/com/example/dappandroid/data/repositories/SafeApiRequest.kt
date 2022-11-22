package com.example.dappandroid.data.repositories

import com.example.dappandroid.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource <T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Sucess(apiCall.invoke())
            } catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException -> {
                        Resource.Failure(false,throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Failure(true, null, null)
                    }
                }
            }
        }
    }


//    suspend fun <T: Any> apiRequest(call: suspend () -> Response<T>) : T {
//
//        val response = call.invoke()
//        if(response.isSuccessful){
//            return response.body()!!
//        } else {
//            //@Todo handle api exception
//            throw ApiException(response.code().toString())
//        }
//    }
}

class ApiException(message: String) : IOException(message)