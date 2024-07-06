package com.atakaya.quoteofday.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atakaya.quoteofday.presentation.ui.screens.fav_screens.FavoriteScreen
import com.atakaya.quoteofday.presentation.ui.screens.main_screens.MainScreen
import com.atakaya.quoteofday.presentation.ui.theme.QuoteOfDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            QuoteOfDayTheme {
                Scaffold(
                    containerColor = Color.Cyan,
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    App()
                }
            }


        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "start") {
        composable("start") { MainScreen(navController = navController) }
        composable("favorite") { FavoriteScreen(vaController = navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfDayTheme {
        App()
    }
}
