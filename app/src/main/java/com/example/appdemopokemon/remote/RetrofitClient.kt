package com.example.appdemopokemon.remote

import com.example.appdemopokemon.core.Constants
import com.example.appdemopokemon.remote.pokemon.WebServicePokemon
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val webService: WebServicePokemon by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_POKEMON_SERVICE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(WebServicePokemon::class.java)

    }
}