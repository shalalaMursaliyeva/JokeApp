package com.example.jokeapp

import com.example.jokeapp.api.IJoke
import com.example.jokeapp.network.Singleton

class CONST {

    companion object {
        val BASE_URL = "https://v2.jokeapi.dev/joke/"

        fun getApi(): IJoke? {
            return Singleton.api
        }
    }
}