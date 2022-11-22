package com.example.dappandroid.data.models.user

import com.google.gson.annotations.SerializedName

data class User(
     val apellido: String,
     val email: String,
     val nombre: String,
     val password: String,
     val username: String,
     val telefono: String

)
//
//@SerializedName("apellido") val apellido: String,
//@SerializedName("email")  val email: String,
//@SerializedName("nombre")  val nombre: String,
//@SerializedName("password")  val password: String,
//@SerializedName("username")  val username: String,
//@SerializedName("telefono")  val telefono: String
