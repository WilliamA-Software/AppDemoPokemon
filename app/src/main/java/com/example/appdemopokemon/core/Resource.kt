package com.example.appdemopokemon.core

sealed class Resource<out T>{
class Loading <out T>:Resource<T>()
    data class Success<out T>(val data: T):Resource<T>()
    data class Failure (val error:Exception):Resource<Nothing>()
}
