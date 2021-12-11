package com.kako351.android.pokemon_fav.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kako351.android.pokemon_fav.R
import com.kako351.android.pokemon_fav.ui.theme.MewWhite

@Composable
fun CircleImage(painter: Painter, contentDescription: String, modifier: Modifier = Modifier, size: Dp = 64.dp) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(size).clip(CircleShape).background(color = MewWhite)
    )
}

@Preview
@Composable
fun PreviewCircleImage() {
    CircleImage(painterResource(R.drawable.pikachu), "pikachu")
}

@Preview
@Composable
fun PreviewCircleImageL() {
    CircleImage(painterResource(R.drawable.pikachu), "pikachu", size = 128.dp)
}

@Preview
@Composable
fun PreviewCircleImageXL() {
    CircleImage(painterResource(R.drawable.pikachu), "pikachu", size = 256.dp)
}
