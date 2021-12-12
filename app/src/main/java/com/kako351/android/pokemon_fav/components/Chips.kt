package com.kako351.android.pokemon_fav.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kako351.android.pokemon_fav.ui.theme.PokemonfavTheme

@Composable
fun Chip(
    name: String = "Chip"
) {
    Surface(
        modifier = Modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewLightChip() {
    PokemonfavTheme {
        Chip("Electric")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkChip() {
    PokemonfavTheme {
        Chip("Electric")
    }
}
