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
import com.example.appdemopokemon.databinding.ActivityMainBinding
import com.example.appdemopokemon.presentation.PokemonViewModel
import com.example.appdemopokemon.presentation.PokemonViewModelFactory
import com.example.appdemopokemon.remote.RetrofitClient
import com.example.appdemopokemon.remote.pokemon.PokemonServiceRepoImpl
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val homeViewModel by viewModels<PokemonViewModel> {
        PokemonViewModelFactory(
            PokemonServiceRepoImpl(PokemonDataSource(RetrofitClient.webService))
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
                    binding.tvName.text = result.data.name.toString()
                    Picasso.get().load(result.data.sprites.front_default).into(binding.ivImage)
                    binding.tvDescriptionHeight.text = result.data.height.toString()
                    binding.tvDescriptionWeight.text = result.data.weight.toString()
                    //binding.tvDescriptionAbilities.text = result.data.abilities.toString()

                    val listDataAbilities = mutableListOf<String>()
                    for(i in result.data.abilities){
                        listDataAbilities.add(i.ability.name)
                    }
                    binding.tvDescriptionAbilities.text = listDataAbilities.toString()

                    val listDataTypes = mutableListOf<String>()
                    for(x in result.data.types){
                        listDataTypes.add(x.type.name)
                    }
                    binding.tvDescriptionTypes.text = listDataTypes.toString()


                }
            }
        })
    }
}