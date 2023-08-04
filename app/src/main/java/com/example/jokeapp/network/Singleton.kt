package com.example.jokeapp.network

import com.example.jokeapp.CONST
import com.example.jokeapp.api.IJoke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Singleton {

    var api = Retrofit.Builder()
        .baseUrl(CONST.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IJoke::class.java)

}