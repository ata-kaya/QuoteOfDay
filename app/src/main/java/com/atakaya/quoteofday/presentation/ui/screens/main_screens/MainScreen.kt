package com.atakaya.quoteofday.presentation.ui.screens.main_screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
import com.atakaya.quoteofday.presentation.ui.screens.common.components.ButtonType
import com.atakaya.quoteofday.presentation.ui.screens.common.components.QuoteCard
import com.atakaya.quoteofday.presentation.ui.screens.main_screens.components.BottomBar
import com.atakaya.quoteofday.presentation.ui.screens.main_screens.components.LoadingScreen
import com.atakaya.quoteofday.presentation.ui.screens.main_screens.components.TopBar
import com.atakaya.quoteofday.presentation.ui.state.UIState
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(
    navController: NavController, viewModel: MainViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val shareText by viewModel.shareText.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(shareText) {
        shareText?.let { text ->
            shareQuote(context, text)
            viewModel.clearShareText()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    when (val data = uiState) {
        is UIState.Loading -> LoadingScreen()
        is UIState.Success -> {
            ContentScreen(navController = navController,
                quoteModel = data.data,
                onFavoriteClick = { viewModel.addToFavorite(data) },
                onShareClick = { viewModel.openShareModalVia(data.data) })
        }

        is UIState.Error -> {}
    }
}

@Composable
fun ContentScreen(
    navController: NavController,
    quoteModel: QuoteModel,
    onFavoriteClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Column {
        TopBar(modifier = Modifier.weight(0.1f), navController = navController)
        QuoteCard(
            modifier = Modifier.weight(0.6f), quote = quoteModel
        ) {
            when (it) {
                ButtonType.Favorite -> onFavoriteClick()
                ButtonType.Share -> onShareClick()
            }
        }
        BottomBar(modifier = Modifier.weight(0.1f))
    }
}

fun shareQuote(context: Context, text: String) {
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val chooser = Intent.createChooser(intent, "Share via")
    context.startActivity(chooser)
}
