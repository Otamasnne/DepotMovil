package com.example.dappandroid.data.network

import com.example.dappandroid.data.models.ArticuloItem
import com.example.dappandroid.data.models.ArticuloX
import com.example.dappandroid.data.models.PedidosResponseItem
import com.example.dappandroid.data.models.detalle.Value
import com.example.dappandroid.data.models.user.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface PedidosApi {

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


    @Headers(
        "Authorization: Basic c3ZlbjpwYXNz",
        "Accept: application/json;profile=urn:org.apache.isis/v2;suppress=all")
    @POST("restful/services/simple.Usuarios/actions/userValidation/invoke")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : User




    companion object {
        operator fun invoke() : PedidosApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.18.99:8080/") //"http://10.0.2.2:8080/"
                .build()
                .create(PedidosApi::class.java)
        }
    }
}