package edu.ucne.parcial1_jhon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_jhon.ui.articulo.EditArticuloScreen
import edu.ucne.parcial1_jhon.ui.articulo.HomeArticuloScreen
import edu.ucne.parcial1_jhon.ui.theme.Parcial1_JhonTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_JhonTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "HomeArticuloScreen"
                ) {

                    composable("HomeArticuloScreen") {
                        HomeArticuloScreen(navController = navController)
                    }

                    composable("EditArticuloScreen") {
                        EditArticuloScreen(navController = navController)
                    }

                }

            }
        }
    }
}
