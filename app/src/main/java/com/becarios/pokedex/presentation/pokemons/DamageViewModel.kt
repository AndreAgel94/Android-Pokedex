package com.becarios.pokedex.presentation.pokemons

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.PokemonsDamage
import com.becarios.pokedex.data.repository.PokemonRepository
import com.becarios.pokedex.data.response.damages.weaknesses.DamageBody
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DamageViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    fun getDamage(type: Int): MutableLiveData<List<PokemonsDamage>> {
        return repository.getDamage(type)
    }
}