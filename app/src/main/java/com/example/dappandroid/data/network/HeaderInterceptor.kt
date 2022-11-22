package com.example.dappandroid.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
            "Accept:", "application/json;profile=urn:org.apache.isis/v2;suppress=all"
        )
            .addHeader(
                "Authorization:", "Basic c3ZlbjpwYXNz"
            )
            .build()
        return chain.proceed(request)
    }
}