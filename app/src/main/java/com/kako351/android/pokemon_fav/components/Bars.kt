package com.kako351.android.pokemon_fav.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kako351.android.pokemon_fav.ui.theme.BlackyBlack
import com.kako351.android.pokemon_fav.ui.theme.IwakyBlack
import com.kako351.android.pokemon_fav.ui.theme.LugiaSilver
import com.kako351.android.pokemon_fav.ui.theme.MewWhite
import com.kako351.android.pokemon_fav.ui.theme.PokemonfavTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
        .fillMaxWidth(1f)
        .clip(RoundedCornerShape(50.dp))
        .background(if (isSystemInDarkTheme()) IwakyBlack else LugiaSilver)
        .padding(horizontal = 16.dp, vertical = 8.dp),
    query: String,
    onValueChanges: (String) -> Unit
) {
    var value by remember { mutableStateOf(query) }
    Surface(
        shape = RoundedCornerShape(50.dp),
        elevation = 0.dp,
        modifier = Modifier.background(if (isSystemInDarkTheme()) BlackyBlack else MewWhite)
    ) {
        BasicTextField(
            value = value,
            onValueChange = {
                value = it
            },
            singleLine = true,
            modifier = modifier,
            textStyle = TextStyle(
                color = if (isSystemInDarkTheme()) MewWhite else BlackyBlack
            ),
            cursorBrush = SolidColor(MaterialTheme.colors.primary)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightSearchBar() {
    PokemonfavTheme {
        SearchBar(query = "Pikachu", onValueChanges = {
        })
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkSearchBar() {
    PokemonfavTheme {
        SearchBar(query = "Pikachu", onValueChanges = {
        })
    }
}
