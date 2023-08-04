package com.example.jokeapp.api

import com.example.jokeapp.model.JokeDTO
import retrofit2.Response
import retrofit2.http.GET

interface IJoke {

    @GET("Any")
    suspend fun getJoke(): Response<JokeDTO>

}