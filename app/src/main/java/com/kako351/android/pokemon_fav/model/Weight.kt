package com.kako351.android.pokemon_fav.model

import com.squareup.moshi.Json

data class Weight(
    @Json(name = "maximum")
    val maximum: String,
    @Json(name = "minimum")
    val minimum: String
)
