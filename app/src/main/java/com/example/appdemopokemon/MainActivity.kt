package com.example.appdemopokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.appdemopokemon.core.Resource
import com.example.appdemopokemon.data.remote.PokemonDataSource
import com.example.appdemopokemon.presentation.PokemonViewModel
import com.example.appdemopokemon.presentation.PokemonViewModelFactory
import com.example.appdemopokemon.remote.RetrofitClient
import com.example.appdemopokemon.remote.pokemon.PokemonServiceRepoImpl

class MainActivity : AppCompatActivity() {
    private val homeViewModel by viewModels<PokemonViewModel> {
        PokemonViewModelFactory(
            PokemonServiceRepoImpl(PokemonDataSource(RetrofitClient.webService))
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel.getPokemon().observe(this, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Toast.makeText(this, "cargando", Toast.LENGTH_SHORT).show()

                }
                is Resource.Failure -> {
                    Toast.makeText(this, result.error.localizedMessage, Toast.LENGTH_LONG).show()
                    Log.d("error", result.error.localizedMessage.toString())
                }
                is Resource.Success -> {
                    Toast.makeText(this, result.data.name, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}