package com.jc.appalumno

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServicioAlumno {


    @POST("api/alumno")
    fun guardar(@Body alumno:Alumno): Call<Estatus>

    @POST("api/alumno/autenticar")
    fun autenticar(@Body alumno:Alumno):Call<Alumno>

    @GET("api/alumno/{id}")
    fun buscarPorId(@Path("id") id:String?):Call<Alumno>

    @GET("api/alumno/{email}")
    fun buscarPorEmail(@Path("email") nombre:String?):Call<ArrayList<Alumno>>

    @GET("api/alumno")
    fun buscarTodos():Call<ArrayList<Alumno>>
}