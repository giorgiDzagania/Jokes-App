package com.example.jokes.data

import com.example.jokes.data.local.entity.JokeDbo
import com.example.jokes.data.remote.dto.JokesDto
import com.example.jokes.domain.model.Jokes

fun JokesDto.toJokes() = Jokes(
    id = id,
    punchline = punchline,
    setup = setup,
    type = type
)

fun Jokes.toJokeDbo() = JokeDbo(
    id, punchline, setup
)

fun JokeDbo.toJokes() = Jokes(
    id = id,
    punchline = punchline,
    setup = setup,
    type = "default"
)
