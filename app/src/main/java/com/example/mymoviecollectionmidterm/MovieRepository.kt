package com.example.mymoviecollectionmidterm

import androidx.lifecycle.LiveData

class MovieRepository(private val movieDao: MovieDao) {

    // LiveData exposing the list of all movies from the DAO
    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()

    // Suspend function for inserting a movie into the database
    suspend fun insert(movie: Movie) {
        movieDao.insert(movie)
    }

}
