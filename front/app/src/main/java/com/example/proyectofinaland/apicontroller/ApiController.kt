package com.example.proyectofinaland.apicontroller


import com.example.proyectofinaland.model.Avion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

object ApiController {
    private const val BASE_URL = "http://localhost:8080/*"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val avionService: AvionService by lazy {
        retrofit.create(AvionService::class.java)
    }

}

interface AvionService {
    @GET("aviones")
    suspend fun getAviones(): List<Avion>

    @POST("aviones")
    suspend fun crearAvion(@Body avion: Avion): Avion

}
