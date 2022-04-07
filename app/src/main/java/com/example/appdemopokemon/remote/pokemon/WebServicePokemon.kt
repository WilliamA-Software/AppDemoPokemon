package com.example.appdemopokemon.remote.pokemon

import com.example.appdemopokemon.core.Constants.API
import com.example.appdemopokemon.data.model.Pokemon
import retrofit2.http.GET

interface WebServicePokemon {
    @GET(API)
    suspend fun getPokemon(): Pokemon
}