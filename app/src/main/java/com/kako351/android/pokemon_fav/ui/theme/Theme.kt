package com.kako351.android.pokemon_fav.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val DarkColorPalette = darkColors(
    primary = PikachuYellow,
    primaryVariant = EeveeCamel,
    secondary = HitokageRed,
    background = BlackyBlack
)

private val LightColorPalette = lightColors(
    primary = HitokageRed,
    primaryVariant = GroudonRed,
    secondary = KyogreBlue,
    background = MewWhite

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PokemonfavTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LightTheme() {
    PreviewSample()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkTheme() {
    PreviewSample()
}

@Composable
fun PreviewSample() {
    PokemonfavTheme {
        Surface {
            Column {
                Text(text = "ピカチュウ")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Primary ボタン")
                }
                Text(color = colors.secondary, text = "secondary text")
            }
        }
    }
}
