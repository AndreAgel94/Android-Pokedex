package com.becarios.pokedex.presentation.details.fragments

import android.util.Log
import androidx.lifecycle.*
import com.becarios.pokedex.data.model.PokemonsStats
import com.becarios.pokedex.data.repository.PokemonRepository
import com.becarios.pokedex.data.response.stats.PokemonStats
import com.becarios.pokedex.data.service.APIService
import retrofit2.*

class StatsViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    fun getStats(pokemonId: String, pokemonType: String): MutableLiveData<List<PokemonsStats>> {
        return repository.getStats(pokemonId,pokemonType)
    }
}