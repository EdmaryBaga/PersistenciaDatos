package com.bignerdranch.android.persistenciadatos

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (context: Context) {
    val PREFS_NAME = "Preferencias_usuario"
    val SHARED_NAME = "shared_name"

    /**
     * Con MODE_PRIVATE solo tiene acceso a las preferencias la aplicacion actual, para que mas apps tengan acceso se debe
     * usar MODE_WORLD_READABLE
     * y para que otras puedan consuiltar y modificar usar MODE_WORLD_WRITABLE
     * **/
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    //creamos las variables que perteneceran a nuestro SharedPreferences

    /**
     * Agregamos un nombre a la variable que contendra la inf.
     * 2.- creamos el metodo get para obtener la inf
     * 3.- hacemos que nuestra variable pueda ser seteada
     * **/
    var nombreUsuariio:String?
        get()=prefs.getString(SHARED_NAME,"")
        set(value) = prefs.edit().putString(SHARED_NAME,value).apply()

    var aPaterno:String?
        get()=prefs.getString("apPaterno","apPaterno")
        set(value) = prefs.edit().putString("apPaterno",value).apply()

    var aMaterno:String?
        get()=prefs.getString("apMaterno","apMaterno")
        set(value)=prefs.edit().putString("apMaterno",value).apply()

}


//creamos la clase desde la que se accedera al objeto de la preferencia y la metemos a un companion object para que pueda ser accedida
class SharedApp : Application() {


    companion object {
        lateinit var prefs: MySharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}