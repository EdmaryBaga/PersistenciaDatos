package com.bignerdranch.android.persistenciadatos.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ProductosApi{
    @GET("/v2/5ce2f514340000548877380b")
    fun obtenProductos(): Call<ResponseProd>

    //En el baseURL solo se coloca lo que esta antes de la primera /

    companion object{
        fun creaCliente():ProductosApi{
            val retrofit= Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ProductosApi::class.java)
        }


    }

}