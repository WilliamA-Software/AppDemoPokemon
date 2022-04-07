package com.example.appdemopokemon.data.model

data class Pokemon(
    val abilities: List<Ability> = listOf(),
    val height: Int = 0,
    val name: String = "",
    val sprites: Sprite = Sprite(),
    val types: List<Type> = listOf(),
    val weight: Int = 0
)

data class Ability(val name: String = "")
data class Sprite(val front_default: String = "")
data class Type(val names: String = "")