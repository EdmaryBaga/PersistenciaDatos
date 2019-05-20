package com.bignerdranch.android.persistenciadatos.model

import com.bignerdranch.android.persistenciadatos.login
import com.bignerdranch.android.persistenciadatos.usuario
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface loginApi {

    /**
     * con el Header indicamos que la aplicacion enviara un Json a la peticion
     * **/
    @Headers("Content-Type:application/json")
    @POST(value="/login")
    fun sendLogin(@Body loginUser:login): Call<usuario>


    //esto se coloca aqui para que cadavez que se llame no se tenga que crear un cliente
    companion object{
        fun crearCliente(): loginApi{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://5ca637e23a082600142794d8.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create((loginApi::class.java))
        }
    }

}