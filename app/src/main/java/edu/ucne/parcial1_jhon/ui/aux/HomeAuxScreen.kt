package edu.ucne.parcial1_jhon.ui.aux

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
import edu.ucne.parcial1_jhon.data.local.entity.Aux

@Composable
fun HomeAuxScreen(
    navController: NavController,
    viewModel: HomeViewModelAux = hiltViewModel()
) {
    Scaffold(

        topBar = {
            HomeAuxTopBar()
        },


        floatingActionButton = {
            HomeAuxFab(
                onFacClicked = { navController.navigate(
                    route = "EditAuxScreen"
                ) }
            )
        },



        content = { innerPadding ->
            val uiState by viewModel.uiState.collectAsState()

            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteAux = {},
                onEditAux = {},
                auxs = uiState.auxs ,
            )
        }
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteAux:(aux: Aux) -> Unit,
    onEditAux: (id: Int?) -> Unit,
    auxs: List<Aux> = emptyList(),
) {

    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier,
    ) {
        LazyColumn{
            items(auxs){ aux ->
                AuxItem(
                    aux = aux,
                    onEditAux = {onEditAux},
                    onDeleteAux = {onDeleteAux})
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
            contentDescription = "Añadir Aux")
    }
}

@Composable
fun HomeAuxTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = "Auxs List",
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
    aux: Aux,
    onEditAux: () -> Unit,
    onDeleteAux: () -> Unit,
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
                    text = "aux1: ${aux.aux1}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "aux2: ${aux.aux2}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "aux2: ${aux.aux3}",
                    style = MaterialTheme.typography.h6
                )
            }

            Row {

                IconButton(onClick = onEditAux) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
                IconButton(onClick = onDeleteAux) {
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
