package com.example.mymoviecollectionmidterm

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    companion object {
        fun getDatabase(application: Application): Any {

        }
        // Singleton instance setup for database
    }
}
