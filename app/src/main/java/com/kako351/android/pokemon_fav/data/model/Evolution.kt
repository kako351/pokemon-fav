package com.kako351.android.pokemon_fav.data.model

import com.squareup.moshi.Json

data class Evolution(
    @Json(name = "id")
    val id: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: String
)
