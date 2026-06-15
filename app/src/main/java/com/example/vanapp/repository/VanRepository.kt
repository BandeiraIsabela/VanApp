package com.example.vanapp.repository

import android.content.Context
import com.example.vanapp.database.AppDatabase
import com.example.vanapp.model.Van
import com.example.vanapp.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VanRepository(context: Context) {

    private val vanDao = AppDatabase.getDatabase(context).vanDao()

    suspend fun getVans(): List<Van> {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitClient.api.getUsers().execute()
                if (response.isSuccessful) {
                    val users = response.body() ?: emptyList()
                    val vansFromApi = users.map {
                        Van(rota = it.name, motorista = "Motorista ${it.id}", horario = "07:00")
                    }
                    vanDao.deleteAll()
                    vanDao.insertAll(vansFromApi)
                }
            } catch (e: Exception) {
                // Fallback to local data if network fails
            }
            vanDao.getAllVans()
        }
    }
}