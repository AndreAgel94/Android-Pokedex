package com.becarios.pokedex.presentation.pokemons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsDamage
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.repository.PokemonRepository

class PokemonViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    var justForPaginationLiveData: MutableLiveData<List<Pokemons>> = MutableLiveData()

    fun getPokemon(): MutableLiveData<List<Pokemons>> {
        justForPaginationLiveData = repository.getPokemon()
        return repository.getPokemon()
    }

    fun getPokemonId(pokemonId: String): MutableLiveData<List<PokemonsId>> {
        return repository.getPokemonId(pokemonId)
    }

    fun getPokemonPage(limitPage: Int) { 
        repository.getPokemonPage(limitPage)
    }
}
