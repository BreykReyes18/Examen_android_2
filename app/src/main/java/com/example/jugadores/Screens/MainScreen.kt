package com.example.jugadores.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.jugadores.Data.Data
import com.example.jugadores.Data.ListaJugadores
import com.example.jugadores.ui.theme.JugadoresTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Top mejores jugadores 2021-2022",textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth())
        }
    }) {

        listado(listJugadores = ListaJugadores().jugadores)

}
}
@Composable
fun listado(listJugadores: List<Data>) {
    LazyColumn{
        items(listJugadores,key = {it.Item}) { list ->
            Content(list)
        }
    }
}

@Composable
fun Content(listJugadores: Data) {
 /* var isExpanded = remember { mutableStateOf(false) }

    val extrapadding = animateDpAsState(
        if (isExpanded.value) 48.dp else 0.dp
    )
*/
    Row(modifier = Modifier.padding(10.dp)/*.clickable { isExpanded.value = !isExpanded.value }.padding(bottom = extrapadding.value)*/) {
        Box(contentAlignment = Alignment.Center,modifier = Modifier.background(color = Color.White).height(150.dp)) {
            AsyncImage(
                model = listJugadores.imagen,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)

            )

            Text(text = "${listJugadores.Item}", fontWeight = FontWeight.Bold, fontSize = 15.sp
                ,color = Color.DarkGray,
                modifier = Modifier.align(Alignment.BottomCenter))
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(text = "${listJugadores.Nombre}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Equipo:", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.size(25.dp))
                Text(text = "${listJugadores.Equipo}", fontSize = 17.sp, modifier = Modifier
                    .alignBy(LastBaseline)
                    .padding(start = 46.dp))
            }
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Nacionalidad:", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.size(18.dp))
                Text(text = "${listJugadores.Nacionalidad}", fontSize = 17.sp)
            }
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Edad:", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.size(25.dp))

                Text(text = "${listJugadores.Edad} años", fontSize = 17.sp, modifier = Modifier
                    .alignBy(LastBaseline)
                    .padding(start = 61.dp))
            }
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Posicion:", fontWeight = FontWeight.Bold, fontSize = 17.sp, modifier = Modifier.padding(start = 20.dp))
                Spacer(modifier = Modifier.size(25.dp))
                Text(text = "${listJugadores.Posicion}", fontSize = 17.sp, modifier = Modifier
                    .alignBy(LastBaseline)
                    .padding(start = 33.dp))
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    JugadoresTheme {
        MainScreen()
    }
}