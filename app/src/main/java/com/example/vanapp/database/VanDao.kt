package com.example.vanapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vanapp.model.Van

@Dao
interface VanDao {
    @Query("SELECT * FROM vans")
    suspend fun getAllVans(): List<Van>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vans: List<Van>)

    @Query("DELETE FROM vans")
    suspend fun deleteAll()
}