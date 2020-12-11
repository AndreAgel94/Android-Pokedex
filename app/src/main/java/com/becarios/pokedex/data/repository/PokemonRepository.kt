package com.becarios.pokedex.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.becarios.pokedex.data.model.Pokemons
import com.becarios.pokedex.data.model.PokemonsDamage
import com.becarios.pokedex.data.model.PokemonsId
import com.becarios.pokedex.data.model.PokemonsStats
import com.becarios.pokedex.data.response.damages.weaknesses.DamageBody
import com.becarios.pokedex.data.response.listagem.PokemonIdResult
import com.becarios.pokedex.data.response.listagem.PokemonRootResponse
import com.becarios.pokedex.data.response.stats.PokemonStats
import com.becarios.pokedex.data.service.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {
    val mLiveData: MutableLiveData<List<Pokemons>> = MutableLiveData()
    val mmLiveData: MutableLiveData<List<PokemonsDamage>> = MutableLiveData()
    val pokemonsList: MutableList<Pokemons> = mutableListOf()
    val pokemonsList2: MutableList<PokemonsDamage> = mutableListOf()
    val _mLiveData: MutableLiveData<List<PokemonsId>> = MutableLiveData()

    val statsLiveData: MutableLiveData<List<PokemonsStats>> = MutableLiveData()
    val pokemonsListstats: MutableList<PokemonsStats> = mutableListOf()


    var pokemonId = 1
    val limitPokemons = 20


    fun getPokemon() : MutableLiveData<List<Pokemons>> {
        APIService.service.getPokemonsId(pokemonId).enqueue(object : Callback<PokemonRootResponse> {
            override fun onResponse(call: Call<PokemonRootResponse>, response: Response<PokemonRootResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { pokemonsType ->

                        val pokemon = Pokemons(
                            id = pokemonsType.id,
                            name = pokemonsType.name,
                            typeName1 = pokemonsType.types[0].type.name,
                            typeName2 = pokemonsType.types.last().type.name
                        )

                        if (pokemonId <= limitPokemons) {
                            pokemonsList.add(pokemon)
                            pokemonId++
                            getPokemon()
                        }
                    }
                    mLiveData.value = pokemonsList
                }
            }

            override fun onFailure(call: Call<PokemonRootResponse>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
        return mLiveData
    }

    fun getPokemonId(pokemonId: String): MutableLiveData<List<PokemonsId>> {

        APIService.service.getPokemonId(pokemonId)
            .enqueue(object : Callback<PokemonIdResult> {
                override fun onResponse(
                    call: Call<PokemonIdResult>,
                    response: Response<PokemonIdResult>
                ) {
                    if (response.isSuccessful) {
                        val pokemonsList: MutableList<PokemonsId> = mutableListOf()
                        response.body()?.let { pokemonsResponse ->

                            for (results in pokemonsResponse.name) {
                                val pokemon = PokemonsId(
                                    name = pokemonsResponse.name,
                                    id = pokemonsResponse.id,
                                    typeName1 = pokemonsResponse.types[0].type.name,
                                    typeName2 = pokemonsResponse.types.last().type.name
                                )
                                pokemonsList.add(pokemon)
                            }
                        }
                        _mLiveData.value = pokemonsList
                    }
                }

                override fun onFailure(call: Call<PokemonIdResult>, t: Throwable) {
                    Log.e("Erro API ", t.message.toString())
                }
            })
        return _mLiveData
    }

    fun getPokemonPage(limitPage: Int) {

        APIService.service.getPokemonsId(pokemonId)
            .enqueue(
                object : Callback<PokemonRootResponse> {
                    override fun onResponse(
                        call: Call<PokemonRootResponse>,
                        response: Response<PokemonRootResponse>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let { pokemonsType ->

                                val pokemon = Pokemons(
                                    id = pokemonsType.id,
                                    name = pokemonsType.name,
                                    typeName1 = pokemonsType.types[0].type.name,
                                    typeName2 = pokemonsType.types.last().type.name
                                )

                                if (pokemonId <= limitPage) {
                                    pokemonsList.add(pokemon)
                                    pokemonId++
                                    getPokemonPage(limitPage)
                                }
                            }
                        }
                    }

                    override fun onFailure(call: Call<PokemonRootResponse>, t: Throwable) {
                        Log.e("Erro API ", t.message.toString())
                    }
                })
    }

    fun getDamage(type: Int): MutableLiveData<List<PokemonsDamage>> {

        APIService.service.getDamage(type).enqueue(object : Callback<DamageBody> {
            override fun onResponse(call: Call<DamageBody>, response: Response<DamageBody>) {
                if (response.isSuccessful) {
                    Log.e("SAPI", "Sussesso API!!!")
                    response.body()?.let { damage ->
                        var damageSize = damage.damage_relations.double_damage_from.size
                        var halfDamageSize = damage.damage_relations.half_damage_from.size

                        if (damageSize == 1 && halfDamageSize == 0) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 2 && halfDamageSize == 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 1 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize == 2 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize == 1) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize == 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                        if (damageSize > 2 && halfDamageSize > 2) {
                            val pokemonDamage = PokemonsDamage(
                                name0 = damage.damage_relations.double_damage_from[0].name,
                                name1 = damage.damage_relations.double_damage_from[1].name,
                                name2 = damage.damage_relations.double_damage_from[2].name,
                                name3 = damage.damage_relations.half_damage_from[0].name,
                                name4 = damage.damage_relations.half_damage_from[1].name,
                                name5 = damage.damage_relations.half_damage_from[2].name
                            )
                            pokemonsList2.add(pokemonDamage)
                        }
                    }
                }
                mmLiveData.value = pokemonsList2
            }
            override fun onFailure(call: Call<DamageBody>, t: Throwable) {
                Log.e("ErroAPI ", t.message.toString())
            }
        })
        return mmLiveData
    }

    fun getStats(pokemonId: String, pokemonType: String): MutableLiveData<List<PokemonsStats>> {

        APIService.service.getStats(pokemonId).enqueue(object : Callback<PokemonStats> {
            override fun onResponse(call: Call<PokemonStats>, response: Response<PokemonStats>) {
                if (response.isSuccessful) {
                    response.body()?.let { stats ->

                        for (results in stats.stats) {
                            val pokemonStats = PokemonsStats(
                                base_stat1 = results.base_stat,
                                name = results.stat.name,
                                pokemonType = pokemonType
                            )
                            pokemonsListstats.add(pokemonStats)
                        }
                    }
                    statsLiveData.value = pokemonsListstats //mliveData
                }
            }
            override fun onFailure(call: Call<PokemonStats>, t: Throwable) {
                Log.e("Erro API ", t.message.toString())
            }
        })
        return statsLiveData
    }
}