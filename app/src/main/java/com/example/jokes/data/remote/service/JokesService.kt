package com.example.jokes.data.remote.service

import com.example.jokes.data.remote.dto.JokesDto
import retrofit2.Response
import retrofit2.http.GET

interface JokesService {

    @GET("random_joke")
    suspend fun getRandomJoke(): Response<JokesDto>


}