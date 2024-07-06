package com.atakaya.quoteofday.presentation.ui.screens.main_screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun TopBar(modifier: Modifier, navController: NavController) {
    Box(
        modifier = modifier
            .padding(end = 32.dp, top = 48.dp)
            .fillMaxWidth()
    ) {
        TextButton(modifier = Modifier.align(Alignment.TopEnd),
            onClick = { navController.navigate("favorite") }) {
            Text(
                text = "Favorites", fontSize = 16.sp, textAlign = TextAlign.End
            )
        }
    }
}
