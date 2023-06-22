package com.example.jugadores.Screens

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jugadores.Data.Data
import com.example.jugadores.Data.ListaJugadores
import com.example.jugadores.R
import com.example.jugadores.navigation.AppNavigation
import com.example.jugadores.navigation.AppScreens
import com.example.jugadores.ui.theme.JugadoresTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Top mejores jugadores 2021-2022",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth())
        }
    }) {

        listado(navController,listJugadores = ListaJugadores().jugadores)

}
}
@Composable
fun listado(navController: NavController,listJugadores: List<Data>) {
    LazyColumn{
        items(listJugadores,key = {it.Item}) { list ->
            Content(navController = navController,listJugadores = list)
        }
    }
}

@Composable
fun Content(navController: NavController,listJugadores: Data) {
    var isExpanded by remember { mutableStateOf(false) }
    val extrapadding = animateDpAsState(
        if (isExpanded) 20.dp else 0.dp
    )
    Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier
        .padding(5.dp)
        .clickable {navController.navigate(AppScreens.Info.route + "/${listJugadores.Item-1}") }
        .padding(bottom = extrapadding.value)
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ) {
        Box(contentAlignment = Alignment.Center,modifier = Modifier
            .background(color = Color.White)) {
            AsyncImage(
                model = listJugadores.imagen,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp).clip(shape = CircleShape)

            )

            Text(text = "${listJugadores.Item}", fontWeight = FontWeight.Bold, fontSize = 15.sp
                ,color = Color.DarkGray,
                modifier = Modifier.align(Alignment.TopEnd))
        }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Text(text = "${listJugadores.Nombre}", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterHorizontally))

                if(isExpanded) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Equipo:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(
                            text = "${listJugadores.Equipo}", fontSize = 17.sp, modifier = Modifier
                                .alignBy(LastBaseline)
                                .padding(start = 46.dp)
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Nacionalidad:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.size(18.dp))
                        Text(text = "${listJugadores.Nacionalidad}", fontSize = 17.sp)
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Edad:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.size(25.dp))

                        Text(
                            text = "${listJugadores.Edad} años",
                            fontSize = 17.sp,
                            modifier = Modifier
                                .alignBy(LastBaseline)
                                .padding(start = 61.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Posicion:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(
                            text = "${listJugadores.Posicion}",
                            fontSize = 17.sp,
                            modifier = Modifier
                                .alignBy(LastBaseline)
                                .padding(start = 33.dp)
                        )
                    }
                }
                IconButton(onClick = {isExpanded =! isExpanded}, modifier = Modifier.align(alignment = Alignment.End)) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if(isExpanded){
                            stringResource(R.string.show_less)
                        } else {
                            stringResource(R.string.show_more)
                        }
                    )

                }
            }

    }
}