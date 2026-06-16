package com.example.vanapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vanapp.model.Van

@Database(entities = [Van::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vanDao(): VanDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "van_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}