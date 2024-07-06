package com.atakaya.quoteofday.presentation.ui.screens.main_screens.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()

    ) {
        IconButton(
            onClick = { /* Handle add button click */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 16.dp)
        ) {
            Icon(Icons.TwoTone.Add, contentDescription = "Add to favorites")
        }
    }
}
