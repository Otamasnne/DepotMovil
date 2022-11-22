package com.example.dappandroid.data.models.detalle

data class Detalle(
    val extensions: Extensions,
    val id: String,
    val links: List<Link>,
    val memberType: String,
    val value: List<Value>
)