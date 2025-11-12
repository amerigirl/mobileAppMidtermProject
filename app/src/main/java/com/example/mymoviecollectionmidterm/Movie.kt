package com.example.mymoviecollectionmidterm

import androidx.room.Entity
import androidx.room.PrimaryKey

// Define the Movie entity
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val director: String,
    val releaseYear: Int,
    val genre: String,
    val rating: Float,

)
