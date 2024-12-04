package com.example.jokes.data.remote.dto

// dto => Data Transfer Object
// dao =? Data access object

data class JokesDto(
    val id: Int,
    val setup: String,
    val punchline: String,
    val type: String
)