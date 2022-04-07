package com.example.appdemopokemon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.appdemopokemon.core.Resource
import com.example.appdemopokemon.remote.pokemon.PokemonServiceRepo
import kotlinx.coroutines.Dispatchers

class PokemonViewModel(private val repo: PokemonServiceRepo) : ViewModel() {

    fun getPokemon() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getPokemon()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }


}

class PokemonViewModelFactory(private val repo: PokemonServiceRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(repo) as T
    }
}
