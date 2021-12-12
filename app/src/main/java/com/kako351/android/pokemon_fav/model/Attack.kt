package com.kako351.android.pokemon_fav.model

import com.squareup.moshi.Json

data class Attack(
    @Json(name = "damage")
    val damage: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String
)
