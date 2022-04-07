package com.example.appdemopokemon.data.remote

import com.example.appdemopokemon.data.model.Pokemon
import com.example.appdemopokemon.remote.pokemon.WebServicePokemon

class PokemonDataSource(private val webService: WebServicePokemon) {
   suspend fun getPokemon(): Pokemon = webService.getPokemon()
}