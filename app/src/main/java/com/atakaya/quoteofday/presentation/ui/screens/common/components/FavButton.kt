package com.atakaya.quoteofday.presentation.ui.screens.common.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavButton(isFavorite: Boolean, modifier: Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        if (isFavorite) {
            Icon(Icons.Outlined.Favorite, contentDescription = "fav")
        } else {
            Icon(Icons.Outlined.FavoriteBorder, contentDescription = "fav")
        }
    }
}

@Preview
@Composable
private fun FavButtonPreview() {
    FavButton(isFavorite = true, modifier = Modifier, {})
}
