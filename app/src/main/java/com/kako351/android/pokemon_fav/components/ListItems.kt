package com.kako351.android.pokemon_fav.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.kako351.android.pokemon_fav.model.Pokemon
import com.kako351.android.pokemon_fav.ui.theme.PokemonfavTheme

@Composable
fun LowInfoCell(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleImage(rememberImagePainter(pokemon.image), pokemon.name)
        Text(text = pokemon.name, style = MaterialTheme.typography.h6)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightLowInfoCell() {
    PokemonfavTheme {
        Surface {
            LowInfoCell(
                pokemon = Pokemon(
                    id = "sample",
                    name = "pikachu",
                    image = "https://img.pokemondb.net/artwork/pikachu.jpg"
                )
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkLowInfoCell() {
    PokemonfavTheme {
        Surface {
            LowInfoCell(
                pokemon = Pokemon(
                    id = "sample",
                    name = "pikachu",
                    image = "https://img.pokemondb.net/artwork/pikachu.jpg"
                )
            )
        }
    }
}
