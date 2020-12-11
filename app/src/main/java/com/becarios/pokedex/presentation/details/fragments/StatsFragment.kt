package com.becarios.pokedex.presentation.details.fragments


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.pokemons.DamageViewModel
import com.becarios.pokedex.presentation.pokemons.EnumPoke
import kotlinx.android.synthetic.main.fragment_stats.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class StatsFragment : Fragment() {
    var value = String()
    var pokemonType = String()
    var id = String()
    var damageType = 0
    private val statsViewModel : StatsViewModel by viewModel()
    private  val damageViewModel : DamageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        statsViewModel.getStats(value,pokemonType).observe(this, Observer {
            it?.let { stats ->
                with(recyclerViewStats) {
                    layoutManager = GridLayoutManager(this@StatsFragment.context, 1)
                    setHasFixedSize(true)
                    adapter = StatsAdapter(stats) {
                    }
                }
            }
        })
        //statsViewModel.getStats(value, pokemonType)
        getDamageType()

        damageViewModel.getDamage(damageType).observe(this, {
            it?.let { damage ->

                txtWeakness1.text = damage[0].name0.capitalize(Locale.ROOT)
                txtWeakness2.text = damage[0].name1.capitalize(Locale.ROOT)
                txtWeakness3.text = damage[0].name2.capitalize(Locale.ROOT)
                txtResist1.text = damage[0].name3.capitalize(Locale.ROOT)
                txtResist2.text = damage[0].name4.capitalize(Locale.ROOT)
                txtResist3.text = damage[0].name5.capitalize(Locale.ROOT)

                if (damage[0].name0.equals("")) {
                    weakness1.visibility = View.GONE
                    weakness1.visibility = View.GONE
                } else {
                    weakness1.visibility = View.VISIBLE
                    weakness1.visibility = View.VISIBLE
                }
                if (damage[0].name1.equals("")) {
                    weakness2.visibility = View.GONE
                    weakness2.visibility = View.GONE
                } else {
                    weakness2.visibility = View.VISIBLE
                    weakness2.visibility = View.VISIBLE
                }
                if (damage[0].name2.equals("")) {
                    weakness3.visibility = View.GONE
                    weakness3.visibility = View.GONE
                } else {
                    weakness3.visibility = View.VISIBLE
                    weakness3.visibility = View.VISIBLE
                }
                if (damage[0].name3.equals("")) {
                    resist1.visibility = View.GONE
                    resist1.visibility = View.GONE
                } else {
                    resist1.visibility = View.VISIBLE
                    resist1.visibility = View.VISIBLE
                }
                if (damage[0].name4.equals("")) {
                    resist2.visibility = View.GONE
                    resist2.visibility = View.GONE
                } else {
                    resist2.visibility = View.VISIBLE
                    resist2.visibility = View.VISIBLE
                }
                if (damage[0].name5.equals("")) {
                    resist3.visibility = View.GONE
                    resist3.visibility = View.GONE
                } else {
                    resist3.visibility = View.VISIBLE
                    resist3.visibility = View.VISIBLE
                }

                when (damage[0].name0) {
                    "fire" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        weakness1.setImageResource(R.drawable.fire)
                        weakness1.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        weakness1.setImageResource(R.drawable.water)
                        weakness1.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        weakness1.setImageResource(R.drawable.ice)
                        weakness1.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        weakness1.setImageResource(R.drawable.grass)
                        weakness1.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        weakness1.setImageResource(R.drawable.poison)
                        weakness1.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        weakness1.setImageResource(R.drawable.fighting)
                        weakness1.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        weakness1.setImageResource(R.drawable.rock)
                        weakness1.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        weakness1.setImageResource(R.drawable.flying)
                        weakness1.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        weakness1.setImageResource(R.drawable.dragon)
                        weakness1.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        weakness1.setImageResource(R.drawable.electric)
                        weakness1.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        weakness1.setImageResource(R.drawable.bug)
                        weakness1.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        weakness1.setImageResource(R.drawable.psychic)
                        weakness1.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        weakness1.setImageResource(R.drawable.ground)
                        weakness1.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        weakness1.setImageResource(R.drawable.fairy)
                        weakness1.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        weakness1.setImageResource(R.drawable.dark)
                        weakness1.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        weakness1.setImageResource(R.drawable.ghost)
                        weakness1.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        weakness1.setImageResource(R.drawable.iron)
                        weakness1.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutWeak1.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        weakness1.setImageResource(R.drawable.normal)
                        weakness1.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name1) {
                    "fire" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        weakness2.setImageResource(R.drawable.fire)
                        weakness2.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        weakness2.setImageResource(R.drawable.water)
                        weakness2.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        weakness2.setImageResource(R.drawable.ice)
                        weakness2.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        weakness2.setImageResource(R.drawable.grass)
                        weakness2.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        weakness2.setImageResource(R.drawable.poison)
                        weakness2.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        weakness2.setImageResource(R.drawable.fighting)
                        weakness2.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        weakness2.setImageResource(R.drawable.rock)
                        weakness2.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        weakness2.setImageResource(R.drawable.flying)
                        weakness2.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        weakness2.setImageResource(R.drawable.dragon)
                        weakness2.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        weakness2.setImageResource(R.drawable.electric)
                        weakness2.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        weakness2.setImageResource(R.drawable.bug)
                        weakness2.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        weakness2.setImageResource(R.drawable.psychic)
                        weakness2.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        weakness2.setImageResource(R.drawable.ground)
                        weakness2.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        weakness2.setImageResource(R.drawable.fairy)
                        weakness2.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        weakness2.setImageResource(R.drawable.dark)
                        weakness2.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        weakness2.setImageResource(R.drawable.ghost)
                        weakness2.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        weakness2.setImageResource(R.drawable.iron)
                        weakness2.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutWeak2.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        weakness2.setImageResource(R.drawable.normal)
                        weakness2.setBackgroundResource(R.drawable.circle_normal)
                    }
                }

                when (damage[0].name2) {
                    "fire" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        weakness3.setImageResource(R.drawable.fire)
                        weakness3.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        weakness3.setImageResource(R.drawable.water)
                        weakness3.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        weakness3.setImageResource(R.drawable.ice)
                        weakness3.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        weakness3.setImageResource(R.drawable.grass)
                        weakness3.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        weakness3.setImageResource(R.drawable.poison)
                        weakness3.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        weakness3.setImageResource(R.drawable.fighting)
                        weakness3.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        weakness3.setImageResource(R.drawable.rock)
                        weakness3.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        weakness3.setImageResource(R.drawable.flying)
                        weakness3.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        weakness3.setImageResource(R.drawable.dragon)
                        weakness3.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        weakness3.setImageResource(R.drawable.electric)
                        weakness3.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        weakness3.setImageResource(R.drawable.bug)
                        weakness3.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        weakness3.setImageResource(R.drawable.psychic)
                        weakness3.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        weakness3.setImageResource(R.drawable.ground)
                        weakness3.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        weakness3.setImageResource(R.drawable.fairy)
                        weakness3.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        weakness3.setImageResource(R.drawable.dark)
                        weakness3.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        weakness3.setImageResource(R.drawable.ghost)
                        weakness3.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        weakness3.setImageResource(R.drawable.iron)
                        weakness3.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutWeak3.contentDescription =
                            ("Fraco contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        weakness3.setImageResource(R.drawable.normal)
                        weakness3.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name3) {
                    "fire" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        resist1.setImageResource(R.drawable.fire)
                        resist1.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        resist1.setImageResource(R.drawable.water)
                        resist1.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        resist1.setImageResource(R.drawable.ice)
                        resist1.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        resist1.setImageResource(R.drawable.grass)
                        resist1.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        resist1.setImageResource(R.drawable.poison)
                        resist1.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        resist1.setImageResource(R.drawable.fighting)
                        resist1.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        resist1.setImageResource(R.drawable.rock)
                        resist1.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        resist1.setImageResource(R.drawable.flying)
                        resist1.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        resist1.setImageResource(R.drawable.dragon)
                        resist1.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        resist1.setImageResource(R.drawable.electric)
                        resist1.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        resist1.setImageResource(R.drawable.bug)
                        resist1.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        resist1.setImageResource(R.drawable.psychic)
                        resist1.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        resist1.setImageResource(R.drawable.ground)
                        resist1.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        resist1.setImageResource(R.drawable.fairy)
                        resist1.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        resist1.setImageResource(R.drawable.dark)
                        resist1.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        resist1.setImageResource(R.drawable.ghost)
                        resist1.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        resist1.setImageResource(R.drawable.iron)
                        resist1.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutResist1.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        resist1.setImageResource(R.drawable.normal)
                        resist1.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name4) {
                    "fire" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        resist2.setImageResource(R.drawable.fire)
                        resist2.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        resist2.setImageResource(R.drawable.water)
                        resist2.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        resist2.setImageResource(R.drawable.ice)
                        resist2.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        resist2.setImageResource(R.drawable.grass)
                        resist2.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        resist2.setImageResource(R.drawable.poison)
                        resist2.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        resist2.setImageResource(R.drawable.fighting)
                        resist2.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        resist2.setImageResource(R.drawable.rock)
                        resist2.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        resist2.setImageResource(R.drawable.flying)
                        resist2.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        resist2.setImageResource(R.drawable.dragon)
                        resist2.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        resist2.setImageResource(R.drawable.electric)
                        resist2.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        resist2.setImageResource(R.drawable.bug)
                        resist2.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        resist2.setImageResource(R.drawable.psychic)
                        resist2.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        resist2.setImageResource(R.drawable.ground)
                        resist2.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        resist2.setImageResource(R.drawable.fairy)
                        resist2.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        resist2.setImageResource(R.drawable.dark)
                        resist2.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        resist2.setImageResource(R.drawable.ghost)
                        resist2.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        resist2.setImageResource(R.drawable.iron)
                        resist2.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutResist2.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        resist2.setImageResource(R.drawable.normal)
                        resist2.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
                when (damage[0].name5) {
                    "fire" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIRE.typeName}")
                        resist3.setImageResource(R.drawable.fire)
                        resist3.setBackgroundResource(R.drawable.circle_fire)
                    }
                    "water" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.WATER.typeName}")
                        resist3.setImageResource(R.drawable.water)
                        resist3.setBackgroundResource(R.drawable.circle_water)
                    }
                    "ice" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ICE.typeName}")
                        resist3.setImageResource(R.drawable.ice)
                        resist3.setBackgroundResource(R.drawable.circle_ice)
                    }
                    "grass" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GRASS.typeName}")
                        resist3.setImageResource(R.drawable.grass)
                        resist3.setBackgroundResource(R.drawable.circle_grass)
                    }
                    "poison" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.POISON.typeName}")
                        resist3.setImageResource(R.drawable.poison)
                        resist3.setBackgroundResource(R.drawable.circle_poison)
                    }
                    "fighting" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FIGHTING.typeName}")
                        resist3.setImageResource(R.drawable.fighting)
                        resist3.setBackgroundResource(R.drawable.circle_fighting)
                    }
                    "rock" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ROCK.typeName}")
                        resist3.setImageResource(R.drawable.rock)
                        resist3.setBackgroundResource(R.drawable.circle_rock)
                    }
                    "flying" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FLYING.typeName}")
                        resist3.setImageResource(R.drawable.flying)
                        resist3.setBackgroundResource(R.drawable.circle_flying)
                    }
                    "dragon" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DRAGON.typeName}")
                        resist3.setImageResource(R.drawable.dragon)
                        resist3.setBackgroundResource(R.drawable.circle_dragon)
                    }
                    "electric" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.ELECTRIC.typeName}")
                        resist3.setImageResource(R.drawable.electric)
                        resist3.setBackgroundResource(R.drawable.circle_electric)
                    }
                    "bug" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.BUG.typeName}")
                        resist3.setImageResource(R.drawable.bug)
                        resist3.setBackgroundResource(R.drawable.circle_bug)
                    }
                    "psychic" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.PSYCHIC.typeName}")
                        resist3.setImageResource(R.drawable.psychic)
                        resist3.setBackgroundResource(R.drawable.circle_psychic)
                    }
                    "ground" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GROUND.typeName}")
                        resist3.setImageResource(R.drawable.ground)
                        resist3.setBackgroundResource(R.drawable.circle_ground)
                    }
                    "fairy" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.FAIRY.typeName}")
                        resist3.setImageResource(R.drawable.fairy)
                        resist3.setBackgroundResource(R.drawable.circle_fairy)
                    }
                    "dark" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.DARK.typeName}")
                        resist3.setImageResource(R.drawable.dark)
                        resist3.setBackgroundResource(R.drawable.circle_dark)
                    }
                    "ghost" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.GHOST.typeName}")
                        resist3.setImageResource(R.drawable.ghost)
                        resist3.setBackgroundResource(R.drawable.circle_ghost)
                    }
                    "steel" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.STEEL.typeName}")
                        resist3.setImageResource(R.drawable.iron)
                        resist3.setBackgroundResource(R.drawable.circle_iron)
                    }
                    "normal" -> {
                        linearLayoutResist3.contentDescription =
                            ("Resistente contra pokémonsdo tipo: ${EnumPoke.NORMAL.typeName}")
                        resist3.setImageResource(R.drawable.normal)
                        resist3.setBackgroundResource(R.drawable.circle_normal)
                    }
                }
            }
        })
    }

    private fun getDamageType() {
        when (pokemonType) {
            "fire" -> damageType = 10
            "grass" -> damageType = 12
            "poison" -> damageType = 4
            "dragon" -> damageType = 16
            "flying" -> damageType = 3
            "ghost" -> damageType = 8
            "ground" -> damageType = 5
            "normal" -> damageType = 1
            "psychic" -> damageType = 14
            "fairy" -> damageType = 18
            "rock" -> damageType = 6
            "steel" -> damageType = 9
            "water" -> damageType = 11
            "dark" -> damageType = 11
            "bug" -> damageType = 7
            "electric" -> damageType = 13
            "fighting" -> damageType = 2
            "ice" -> damageType = 15
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()
        changeTitlesColor()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String, type: String) = StatsFragment().apply {
            arguments = Bundle().apply {
                putString("ID", "id")
                putString("TYPE", "type")
                value = id
                pokemonType = type
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeTitlesColor() {
        when (pokemonType) {
            util.Constant.FIRE -> {
                txtWeak.setTextAppearance(R.style.Fire)
                txtResist.setTextAppearance(R.style.Fire)
            }
            util.Constant.WATER -> {
                txtWeak.setTextAppearance(R.style.Water)
                txtResist.setTextAppearance(R.style.Water)
            }
            util.Constant.ICE -> {
                txtWeak.setTextAppearance(R.style.Ice)
                txtResist.setTextAppearance(R.style.Ice)
            }
            util.Constant.GRASS -> {
                txtWeak.setTextAppearance(R.style.Grass)
                txtResist.setTextAppearance(R.style.Grass)
            }
            util.Constant.POISON -> {
                txtWeak.setTextAppearance(R.style.Poison)
                txtResist.setTextAppearance(R.style.Poison)
            }
            util.Constant.FIGHTING -> {
                txtWeak.setTextAppearance(R.style.Fight)
                txtResist.setTextAppearance(R.style.Fight)
            }
            util.Constant.ROCK -> {
                txtWeak.setTextAppearance(R.style.Rock)
                txtResist.setTextAppearance(R.style.Rock)
            }
            util.Constant.FLYING -> {
                txtWeak.setTextAppearance(R.style.Flying)
                txtResist.setTextAppearance(R.style.Flying)
            }
            util.Constant.DRAGON -> {
                txtWeak.setTextAppearance(R.style.Dragon)
                txtResist.setTextAppearance(R.style.Dragon)
            }
            util.Constant.ELECTRIC -> {
                txtWeak.setTextAppearance(R.style.Electric)
                txtResist.setTextAppearance(R.style.Electric)
            }
            util.Constant.BUG -> {
                txtWeak.setTextAppearance(R.style.Bug)
                txtResist.setTextAppearance(R.style.Bug)
            }
            util.Constant.PSYCHIC -> {
                txtWeak.setTextAppearance(R.style.Psychic)
                txtResist.setTextAppearance(R.style.Psychic)
            }
            util.Constant.GROUND -> {
                txtWeak.setTextAppearance(R.style.Ground)
                txtResist.setTextAppearance(R.style.Ground)
            }
            util.Constant.FAIRY -> {
                txtWeak.setTextAppearance(R.style.Fairy)
                txtResist.setTextAppearance(R.style.Fairy)
            }
            util.Constant.DARK -> {
                txtWeak.setTextAppearance(R.style.Dark)
                txtResist.setTextAppearance(R.style.Dark)
            }
            util.Constant.GHOST -> {
                txtWeak.setTextAppearance(R.style.Ghost)
                txtResist.setTextAppearance(R.style.Ghost)
            }
            util.Constant.STEEL -> {
                txtWeak.setTextAppearance(R.style.Steel)
                txtResist.setTextAppearance(R.style.Steel)
            }
            util.Constant.NORMAL -> {
                txtWeak.setTextAppearance(R.style.Normal)
                txtResist.setTextAppearance(R.style.Normal)
            }
        }
    }
}











