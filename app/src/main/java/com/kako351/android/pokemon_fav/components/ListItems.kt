package com.kako351.android.pokemon_fav.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kako351.android.pokemon_fav.R
import com.kako351.android.pokemon_fav.model.Pokemon
import com.kako351.android.pokemon_fav.ui.theme.PokemonfavTheme

@Composable
fun LowInfoCell(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleImage(
            rememberImagePainter(data = pokemon.image, builder = {
                crossfade(true)
                placeholder(R.drawable.pokemon_placeholder)
            }),
            pokemon.name
        )
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

@Composable
fun CardColumnCell(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SquareImage(
                painter = rememberImagePainter(data = pokemon.image, builder = {
                    crossfade(true)
                    placeholder(R.drawable.pokemon_placeholder)
                }),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .aspectRatio(1f)
            )
            Text(text = pokemon.name, style = MaterialTheme.typography.h5)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightCardColumnCell() {
    PokemonfavTheme {
        Surface {
            CardColumnCell(
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
fun PreviewDarkCardColumnCell() {
    PokemonfavTheme {
        Surface {
            CardColumnCell(
                pokemon = Pokemon(
                    id = "sample",
                    name = "pikachu",
                    image = "https://img.pokemondb.net/artwork/pikachu.jpg"
                )
            )
        }
    }
}

@Composable
fun ListRecordCell(modifier: Modifier = Modifier, pokemon: Pokemon) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row {
            SquareImage(
                painter = rememberImagePainter(data = pokemon.image, builder = {
                    crossfade(true)
                    placeholder(R.drawable.pokemon_placeholder)
                }),
                contentDescription = pokemon.name,
                size = 64.dp
            )
            Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                Row {
                    pokemon.types?.forEach {
                        Chip(it)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = pokemon.name, style = MaterialTheme.typography.h5)
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightListRecordCell() {
    PokemonfavTheme {
        Surface {
            ListRecordCell(
                pokemon = Pokemon(
                    id = "sample",
                    name = "pikachu",
                    image = "https://img.pokemondb.net/artwork/pikachu.jpg",
                    types = listOf("Electric")
                )
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkListRecordCell() {
    PokemonfavTheme {
        Surface {
            ListRecordCell(
                pokemon = Pokemon(
                    id = "sample",
                    name = "pikachu",
                    image = "https://img.pokemondb.net/artwork/pikachu.jpg",
                    types = listOf("Electric")
                )
            )
        }
    }
}
