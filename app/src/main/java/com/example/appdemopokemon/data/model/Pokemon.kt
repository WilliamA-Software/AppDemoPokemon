package com.example.appdemopokemon.data.model

data class Pokemon(
    val abilities: List<Ability> = listOf(),
    val height: Int = 0,
    val name: String = "",
    val sprites: Sprite = Sprite(),
    val types: List<Type> = listOf(),
    val weight: Int = 0
)

data class Ability(var ability:AbilityData, val is_hidden: Boolean, var slot:Int )
data class AbilityData(val name: String = "", val url: String)

data class Sprite(val front_default: String = "")

data class Type(var slot:Int, val type: TypeData)
data class TypeData(val name: String = "", val url: String)