package com.example.jokeapp.model

data class JokeDTO(
    var error: Boolean,
    var category: String,
    var type: String,
    var setup: String,
    var delivery: String,
    var flags: Flags,
    var id: Int,
    var safe: Boolean,
    var lang: String

)



