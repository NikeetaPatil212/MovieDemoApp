package com.example.plexigoappdemo.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class BasicInterceptor() :
    Interceptor {
    private val credentials: String
    private val user_id: String = "UserId"
    private val password: String = "59274"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("X-API-Key", "03a53461dfdf11ea85d10a5cd31394da").build()
        return chain.proceed(authenticatedRequest)
    }

    init {
        credentials = Credentials.basic(user_id,password)
    }
}
