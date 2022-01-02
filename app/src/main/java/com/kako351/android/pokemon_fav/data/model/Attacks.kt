package com.kako351.android.pokemon_fav.data.model

import com.squareup.moshi.Json

data class Attacks(
    @Json(name = "fast")
    val fast: List<Attack>,
    @Json(name = "special")
    val special: List<Attack>
)
