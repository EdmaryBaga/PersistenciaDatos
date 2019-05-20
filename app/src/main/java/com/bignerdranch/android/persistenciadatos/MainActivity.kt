package com.bignerdranch.android.persistenciadatos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bignerdranch.android.persistenciadatos.model.loginApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var texto:TextView = findViewById(R.id.text_message)

        /**
         * 1.- crea el cliente
         * 2.- realiza el call con sus metodos onResponce y onFailure
         * **/

        //creamos el modelo que se enviara en el post
        var model= login("contraseña3", "usuario3")

        //creamos el objeto del api, para crear el cliente
        val login:loginApi = loginApi.crearCliente()

        //Realizamos la llamada el servicio
        val call: Call<usuario> = login.sendLogin(model)
        call.enqueue(object : Callback<usuario>{
            override fun onFailure(call: Call<usuario>?, t: Throwable?) {
                texto.setText("No se realizo la peticion")
            }
            
            override fun onResponse(call: Call<usuario>?, response: Response<usuario>?) {
                var respuesta= response?.body()
                //se setean los datos del SharedPreferences
                SharedApp.prefs.nombreUsuariio=respuesta?.nombre!!
                SharedApp.prefs.aPaterno=respuesta?.apaterno
                SharedApp.prefs.aMaterno=respuesta?.amaterno
                //Se obtienen las variables del SharedPreferences
                var nombre = "Bienvenido ${SharedApp.prefs.nombreUsuariio} ${SharedApp.prefs.aPaterno}  ${SharedApp.prefs.aMaterno}"
                nom_usu.setText(nombre)
                texto.setText("Se realizo la peticion")
            }

        })
    }
}
