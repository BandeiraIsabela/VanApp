package com.example.vanapp.repository

import com.example.vanapp.database.VanDao
import com.example.vanapp.model.Van
import com.example.vanapp.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VanRepository(private val vanDao: VanDao) {

    suspend fun getVans(): List<Van> {
        return withContext(Dispatchers.IO) {
            try {
                // Retrofit agora usa suspend function, retornando a lista diretamente
                val users = RetrofitClient.api.getUsers()
                val vansFromApi = users.map {
                    Van(rota = it.name, motorista = "Motorista ${it.id}", horario = "07:00")
                }
                
                // Room suspend functions
                vanDao.deleteAll()
                vanDao.insertAll(vansFromApi)
            } catch (e: Exception) {
                // Em caso de erro (ex: sem internet), o Room retornará os dados cacheados
            }
            vanDao.getAllVans()
        }
    }
}