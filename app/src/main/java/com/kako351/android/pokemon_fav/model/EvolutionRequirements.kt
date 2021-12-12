package com.kako351.android.pokemon_fav.model

import com.squareup.moshi.Json

data class EvolutionRequirements(
    @Json(name = "amount")
    val amount: Int,
    @Json(name = "name")
    val name: String
)
