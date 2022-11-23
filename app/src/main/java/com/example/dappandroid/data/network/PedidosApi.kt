package com.example.dappandroid.data.network

import androidx.viewbinding.BuildConfig
import com.example.dappandroid.data.models.ArticuloItem
import com.example.dappandroid.data.models.ArticuloX
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.data.models.detalle.Value
import com.example.dappandroid.data.models.user.User
import com.example.dappandroid.data.models.user.UserBody
import com.example.dappandroid.data.models.user.userDos
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface PedidosApi {




//    @GET("restful/services/depotapp.Pedidos/actions/listAll/invoke/")
//    suspend fun getPedidos() : Response<List<PedidosResponseItem>>

    @Headers(
        "Authorization: Basic c3ZlbjpwYXNz",
        "Accept: application/json;profile=urn:org.apache.isis/v2;suppress=all")
    @GET("restful/services/depotapp.Pedidos/actions/listAll/invoke/")
    suspend fun getPedidos() : Response<List<PedidosResponseItem>>

//    @Headers(
//        "Authorization: Basic c3ZlbjpwYXNz",
//        "application/json;profile=urn:org.apache.isis/v2;suppress=all")
//        //"Accept: application/json;profile=urn:org.restfulobjects:repr-types/object-collection")
//    @GET("restful/objects/depotapp.Pedido/1/collections/items")
//    suspend fun getArticulos() : Response<List<ArticuloX>>

    @Headers(
        "Authorization: Basic c3ZlbjpwYXNz",
        "Accept: application/json;profile=urn:org.restfulobjects:repr-types/object-collection")
    @GET("restful/objects/depotapp.Pedido/1/collections/items")
    suspend fun getArticulos() : Response<List<ArticuloX>>


//    @FormUrlEncoded
//    @Headers(
//        "Authorization: Basic c3ZlbjpwYXNz",
//        "Accept: application/json;profile=urn:org.apache.isis/v2;suppress=all",
//        "Content-Type: application/json")
//    @POST("restful/services/simple.Usuarios/actions/userValidation/invoke")
//    suspend fun login(
//        @Field("username") username: String,
//        @Field("password") password: String
//    ) : User

    @Headers(
        "Authorization: Basic c3ZlbjpwYXNz",
        "Content-Type: application/json",
        //"Content-Length: <calculated when request is sent>",
        //"Host: <calculated when request is sent>",
        "Accept: application/json;profile=urn:org.apache.isis/v2;suppress=all")
    @POST("restful/services/depotapp.Usuarios/actions/userValidation/invoke")
    suspend fun login(@Body userData: userDos) : User




    companion object {
        operator fun invoke() : PedidosApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.18.99:8080/") // // "http://10.0.2.2:8080/"
                .build()
                .create(PedidosApi::class.java)
        }

    }





//    companion object {
//        operator fun invoke() : PedidosApi {
//            return Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://192.168.18.99:8080/") //"http://10.0.2.2:8080/"
//                .build()
//                .create(PedidosApi::class.java)
//        }
//    }
}