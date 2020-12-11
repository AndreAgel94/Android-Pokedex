package com.becarios.pokedex.di

import com.becarios.pokedex.data.repository.PokemonRepository
import com.becarios.pokedex.presentation.details.fragments.StatsViewModel
import com.becarios.pokedex.presentation.pokemons.DamageViewModel
import com.becarios.pokedex.presentation.pokemons.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        PokemonViewModel(
            get()
        )
    }

    viewModel {
        DamageViewModel(
            get()
        )
    }

    viewModel {
        StatsViewModel(
            get()
        )
    }
    factory { PokemonRepository() }


}