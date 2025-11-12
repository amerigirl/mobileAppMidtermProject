package com.example.mymoviecollectionmidterm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

//MovieDao interface
@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)
    @Update
    suspend fun update(movie: Movie)
    @Delete
    suspend fun delete(movie: Movie)
    @Query("SELECT * FROM movies ORDER BY title ASC")
    fun getAllMovies(): LiveData<List<Movie>>

}