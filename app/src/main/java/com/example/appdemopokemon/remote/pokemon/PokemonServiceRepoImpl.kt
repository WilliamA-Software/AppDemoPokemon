package com.example.appdemopokemon.remote.pokemon

import com.example.appdemopokemon.data.model.Pokemon
import com.example.appdemopokemon.data.remote.PokemonDataSource

class PokemonServiceRepoImpl(private val dataSource: PokemonDataSource): PokemonServiceRepo {
    override suspend fun getPokemon(): Pokemon = dataSource.getPokemon()
}