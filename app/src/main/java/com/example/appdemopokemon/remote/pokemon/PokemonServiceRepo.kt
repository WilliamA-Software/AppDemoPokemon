package com.example.appdemopokemon.remote.pokemon

import com.example.appdemopokemon.data.model.Pokemon

interface PokemonServiceRepo {
    suspend fun getPokemon():Pokemon
}