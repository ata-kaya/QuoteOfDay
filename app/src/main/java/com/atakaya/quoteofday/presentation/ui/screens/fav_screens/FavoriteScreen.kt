package com.atakaya.quoteofday.presentation.ui.screens.fav_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(vaController: NavController, viewModel: FavoriteViewModel = koinViewModel()) {
    val favData by viewModel.favList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllFaves()
    }

    LazyColumn(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxHeight()
    ) {
        items(items = favData, itemContent = { item ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
                    .padding(horizontal = 25.dp)
                    .background(Color.LightGray)
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                text = item?.quote ?: ""
            )
        })
    }
}
