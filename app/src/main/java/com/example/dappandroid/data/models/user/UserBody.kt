package com.example.dappandroid.data.models.user

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class UserBody(

    val username: String,
    val password: String

)

//    @SerializedName("username") val username: String,
//    @SerializedName("password") val password: String