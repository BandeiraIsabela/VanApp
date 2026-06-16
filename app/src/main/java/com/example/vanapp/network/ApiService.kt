package com.example.vanapp.network

import com.example.vanapp.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>
}
