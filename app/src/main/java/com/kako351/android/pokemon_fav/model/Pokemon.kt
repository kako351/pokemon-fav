package com.kako351.android.pokemon_fav.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "attacks")
    val attacks: Attacks,
    @Json(name = "classification")
    val classification: String,
    @Json(name = "evolutionRequirements")
    val evolutionRequirements: EvolutionRequirements,
    @Json(name = "evolutions")
    val evolutions: List<Evolution>,
    @Json(name = "fleeRate")
    val fleeRate: Double,
    @Json(name = "height")
    val height: Height,
    @Json(name = "id")
    val id: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "maxCP")
    val maxCP: Int,
    @Json(name = "maxHP")
    val maxHP: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: String,
    @Json(name = "resistant")
    val resistant: List<String>,
    @Json(name = "types")
    val types: List<String>,
    @Json(name = "weaknesses")
    val weaknesses: List<String>,
    @Json(name = "weight")
    val weight: Weight
)
