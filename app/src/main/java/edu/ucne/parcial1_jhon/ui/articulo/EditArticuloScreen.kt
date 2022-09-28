package edu.ucne.parcial1_jhon.ui.articulo

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditArticuloScreen(
    navController: NavHostController,
    //viewModel: EditViewModelAux = hiltViewModel()
) {

    Scaffold(

        topBar = {
            EditAuxTopBar(
                topAppBarText = "Añadir Articulos"
            )
        },

        content = {
            //CONTENIDO
        },

        bottomBar = {
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 18.dp),
                shape = CircleShape,
                border= BorderStroke(1.dp, Color.Green),
                onClick = { navController.navigate(
                    route = "HomeArticuloScreen")},
                enabled = true

            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = null
                )
                Text(text = "Añadir Articulos")
            }

            /*
            EditBottomBar(
                onInsertOcupacion = {}
            )*/
        }

    )
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertAux: () -> Unit,
    isError: Boolean = true
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 18.dp),
        shape = CircleShape,
        border= BorderStroke(1.dp, Color.Green),
        onClick = { onInsertAux() },
        enabled = isError

    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = null
        )
        Text(text = "Añadir Aux")
    }
}

@Composable
fun EditConten() {

}

@Composable
fun EditAuxTopBar(topAppBarText: String) {

    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )

}

