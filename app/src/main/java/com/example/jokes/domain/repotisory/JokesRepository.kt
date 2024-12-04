package com.example.jokes.domain.repotisory

import com.example.jokes.core.OperationStatus
import com.example.jokes.domain.model.Jokes

interface JokesRepository {

    suspend fun getRandomJoke(): OperationStatus<Jokes>

    suspend fun saveJoke(joke: Jokes): OperationStatus<Unit>

    suspend fun deleteJoke(joke: Jokes): OperationStatus<Unit>

    suspend fun getAllSavedJokes(): OperationStatus<List<Jokes>>
}