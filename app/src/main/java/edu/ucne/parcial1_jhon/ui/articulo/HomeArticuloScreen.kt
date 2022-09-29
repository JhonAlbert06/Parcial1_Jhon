package edu.ucne.parcial1_jhon.ui.articulo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import edu.ucne.parcial1_jhon.data.local.entity.Articulo

@Composable
fun HomeArticuloScreen(
    navController: NavController,
    viewModel: HomeArticuloViewModel = hiltViewModel()
) {
    Scaffold(

        topBar = {
            HomeAuxTopBar()
        },


        floatingActionButton = {
            HomeAuxFab(
                onFacClicked = { navController.navigate(
                    route = "EditArticuloScreen"
                ) }
            )
        },



        content = { innerPadding ->
            val uiState by viewModel.uiState.collectAsState()

            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteArticulo = {viewModel.delete(it)},
                onEditArticulo = {},
                articulos = uiState.articulos ,
            )
        }
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteArticulo:(articulo: Articulo) -> Unit,
    onEditArticulo: (id: Int?) -> Unit,
    articulos: List<Articulo> = emptyList(),
) {

    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier,
    ) {
        LazyColumn{
            items(articulos){ aux ->
                AuxItem(
                    articulo = aux,
                    onEditArticulo = {onEditArticulo},
                    onDeleteArticulo = {onDeleteArticulo})
            }
        }
    }
}

@Composable
fun HomeAuxFab(
    modifier: Modifier = Modifier,
    onFacClicked: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onFacClicked,
        modifier= modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "Añadir Articulos")
    }
}

@Composable
fun HomeAuxTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "Lista de Articulos",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}


@Composable
fun AuxItem(
    modifier: Modifier = Modifier,
    articulo: Articulo,
    onEditArticulo: () -> Unit,
    onDeleteArticulo: () -> Unit,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Descripcion: ${articulo.descripcion}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Marca: ${articulo.marca}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Existencia: ${articulo.existencia}",
                    style = MaterialTheme.typography.h6
                )
            }

            Row {

                IconButton(onClick = onEditArticulo) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
                IconButton(onClick = onDeleteArticulo) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }

            }

        }
    }
}
