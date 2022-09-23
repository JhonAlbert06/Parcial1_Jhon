package edu.ucne.parcial1_jhon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.parcial1_jhon.ui.aux.EditAuxScreen
import edu.ucne.parcial1_jhon.ui.aux.HomeAuxScreen
import edu.ucne.parcial1_jhon.ui.theme.Parcial1_JhonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_JhonTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "HomeAuxScreen"
                ) {

                    composable("HomeAuxScreen") {
                        HomeAuxScreen(navController = navController)
                    }

                    composable("EditAuxScreen") {
                        EditAuxScreen(navController = navController)
                    }

                }

            }
        }
    }
}
