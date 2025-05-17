package com.example.proyectofinaland.apicontroller


import com.example.proyectofinaland.model.Avion
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path



private const val BASE_URL =
    "http://10.0.2.2:8080/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AvionService {
    @GET("aviones")
    suspend fun getAviones(): List<Avion>

    @POST("aviones")
    suspend fun crearAvion(@Body avion: Avion): Avion

    @PUT("aviones/{id}/piloto")
    suspend fun asignarPiloto(
        @Path("id") avionId: Long,
        @Body body: Map<String, Long>
    ): Avion
}

interface PilotoService {
    @GET("api/pilotos")
    suspend fun getPilotos(): List<Piloto>
}

object ApiController{
    val avionService: AvionService by lazy {
        retrofit.create(AvionService::class.java)
    }

    val pilotoService: PilotoService by lazy {
        retrofit.create(PilotoService::class.java)
    }
}