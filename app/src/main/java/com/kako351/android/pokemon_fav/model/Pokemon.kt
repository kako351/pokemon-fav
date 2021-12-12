package com.kako351.android.pokemon_fav.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "attacks")
    val attacks: Attacks? = null,
    @Json(name = "classification")
    val classification: String? = null,
    @Json(name = "evolutionRequirements")
    val evolutionRequirements: EvolutionRequirements? = null,
    @Json(name = "evolutions")
    val evolutions: List<Evolution>? = null,
    @Json(name = "fleeRate")
    val fleeRate: Double? = null,
    @Json(name = "height")
    val height: Height? = null,
    @Json(name = "id")
    val id: String,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "maxCP")
    val maxCP: Int? = null,
    @Json(name = "maxHP")
    val maxHP: Int? = null,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: String? = null,
    @Json(name = "resistant")
    val resistant: List<String>? = null,
    @Json(name = "types")
    val types: List<String>? = null,
    @Json(name = "weaknesses")
    val weaknesses: List<String>? = null,
    @Json(name = "weight")
    val weight: Weight? = null
)
