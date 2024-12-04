package com.example.jokes.data.repository

import com.example.jokes.JokesApplication
import com.example.jokes.core.NetworkCallHelper
import com.example.jokes.core.OperationStatus
import com.example.jokes.core.map
import com.example.jokes.data.local.JokeDatabase
import com.example.jokes.data.remote.RetrofitInstance
import com.example.jokes.data.remote.dto.JokesDto
import com.example.jokes.data.toJokeDbo
import com.example.jokes.data.toJokes
import com.example.jokes.domain.model.Jokes
import com.example.jokes.domain.repotisory.JokesRepository

class JokesRepositoryImpl : JokesRepository {
    private val jokesService = RetrofitInstance.jokesService
    private val jokeDao = JokeDatabase.create(JokesApplication.context).jokeDao

    // dto to joke
    override suspend fun getRandomJoke(): OperationStatus<Jokes> {
        return NetworkCallHelper.safeApiCall<JokesDto> {
            jokesService.getRandomJoke()
        }.map { jokesDto -> jokesDto.toJokes() }
    }

    // joke to dbo
    override suspend fun saveJoke(joke: Jokes): OperationStatus<Unit> {
        return NetworkCallHelper.safeRoomCall {
            jokeDao.saveJoke(joke = joke.toJokeDbo())
        }
    }

    // dbo to jokes
    override suspend fun getAllSavedJokes(): OperationStatus<List<Jokes>> {
        return NetworkCallHelper.safeRoomCall {
            jokeDao.getAllJokes().map { it.toJokes() } // Use the corrected mapping function
        }
    }

    // joke to dbo
    override suspend fun deleteJoke(joke: Jokes): OperationStatus<Unit> {
        return NetworkCallHelper.safeRoomCall {
            jokeDao.deleteJoke(joke.toJokeDbo())  // Convert the Joke to JokeDbo and delete from the database
        }
    }

}