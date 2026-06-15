package com.example.vanapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vans")
data class Van (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val rota: String,
    val motorista: String,
    val horario: String
)