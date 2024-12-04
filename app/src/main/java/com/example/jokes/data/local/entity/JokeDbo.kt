package com.example.jokes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes_table")
data class JokeDbo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val punchline: String,
    val setup: String
)