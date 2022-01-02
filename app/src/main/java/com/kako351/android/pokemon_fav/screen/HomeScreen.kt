package com.kako351.android.pokemon_fav.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kako351.android.pokemon_fav.R
import com.kako351.android.pokemon_fav.components.CardColumnCell
import com.kako351.android.pokemon_fav.components.LowInfoCell
import com.kako351.android.pokemon_fav.components.SearchBar
import com.kako351.android.pokemon_fav.data.model.Pokemon
import com.kako351.android.pokemon_fav.ui.theme.BlackyBlack
import com.kako351.android.pokemon_fav.ui.theme.MewWhite
import com.kako351.android.pokemon_fav.ui.theme.PokemonfavTheme
import com.kako351.android.pokemon_fav.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = viewModel()
) {
    val pokemon = Pokemon(id = "sample", name = "pikachu", image = "https://img.pokemondb.net/artwork/pikachu.jpg")
    val recentPokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon)
    val favPokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon)
    HomeContents(recentPokemons = recentPokemons, favPokemons = favPokemons)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContents(
    recentPokemons: List<Pokemon>,
    favPokemons: List<Pokemon>
) {
    Scaffold(
        topBar = { HomeTopAppBar() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.recent_header),
                    style = Typography.h1,
                    modifier = Modifier.offset(16.dp)
                )
                RecentPokemon(recentPokemons)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.fav_header),
                    style = Typography.h1,
                    modifier = Modifier.offset(16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                FavPokemons(favPokemons)
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightHomeScreen() {
    val pokemon = Pokemon(id = "sample", name = "pikachu", image = "https://img.pokemondb.net/artwork/pikachu.jpg")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon)
    val favPokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            HomeContents(pokemons, favPokemons)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkHomeScreen() {
    val pokemon = Pokemon(id = "sample", name = "pikachu", image = "https://img.pokemondb.net/artwork/pikachu.jpg")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon)
    val favPokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            HomeContents(pokemons, favPokemons)
        }
    }
}

@Composable
fun RecentPokemon(pokemons: List<Pokemon>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(pokemons) { pokemon ->
            LowInfoCell(pokemon = pokemon, onClick = {})
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightRecentPokemon() {
    val pokemon = Pokemon(id = "sample", name = "pikachu")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            RecentPokemon(pokemons)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkRecentPokemon() {
    val pokemon = Pokemon(id = "sample", name = "pikachu")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            RecentPokemon(pokemons)
        }
    }
}

@Composable
fun HomeTopAppBar() {
    TopAppBar(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 0.dp),
        backgroundColor = if (isSystemInDarkTheme()) BlackyBlack else MewWhite,
        contentPadding = PaddingValues(start = 0.dp, end = 0.dp)
    ) {
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            SearchBar(query = "", onValueChanges = {})
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightHomeTopAppBar() {
    PokemonfavTheme {
        Surface {
            HomeTopAppBar()
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkHomeTopAppBar() {
    PokemonfavTheme {
        Surface {
            HomeTopAppBar()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavPokemons(pokemons: List<Pokemon>) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val halfWidth = (screenWidth / 2)

    pokemons.windowed(size = 2, step = 2, partialWindows = true).forEach { rowPokemons ->
        if (rowPokemons.size < 2) {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                CardColumnCell(
                    modifier = Modifier.width((halfWidth - 16).dp),
                    pokemon = rowPokemons.first(),
                    onClick = {}
                )
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                CardColumnCell(
                    modifier = Modifier.width((halfWidth - 16).dp),
                    pokemon = rowPokemons.first(),
                    onClick = {}
                )
                CardColumnCell(
                    modifier = Modifier.width((halfWidth - 16).dp),
                    pokemon = rowPokemons.last(),
                    onClick = {}
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO, widthDp = 360)
@Composable
fun PreviewLightFavPokemons() {
    val pokemon = Pokemon(id = "sample", name = "pikachu", image = "https://img.pokemondb.net/artwork/pikachu.jpg")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            FavPokemons(pokemons = pokemons)
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, widthDp = 360)
@Composable
fun PreviewDarkFavPokemons() {
    val pokemon = Pokemon(id = "sample", name = "pikachu", image = "https://img.pokemondb.net/artwork/pikachu.jpg")
    val pokemons = listOf(pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon, pokemon)
    PokemonfavTheme {
        Surface {
            FavPokemons(pokemons = pokemons)
        }
    }
}
