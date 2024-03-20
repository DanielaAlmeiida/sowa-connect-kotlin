package br.com.fiap.sowa.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactoryUser {

    private val URL = "https://sowaconnect.free.beeceptor.com/"

    private val retrofitFactoryUser = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUsuarioService(): UsuarioService {
        return retrofitFactoryUser.create(UsuarioService::class.java)
    }

}