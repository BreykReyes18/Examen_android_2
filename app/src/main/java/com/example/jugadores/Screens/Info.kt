package com.example.jugadores.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jugadores.Data.Data
import com.example.jugadores.Data.ListaJugadores

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Info(navController: NavController, Id: Int){
val jugador= ListaJugadores()
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = jugador.jugadores[Id].Nombre,textAlign= TextAlign.Center,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(30.dp)
                    .padding(top = 10.dp))

        }
    }){
        Content_main(navController,Id,jugador)
    }
}
@Composable
fun Content_main(navController: NavController,Id: Int,jugadores: ListaJugadores){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(
        rememberScrollState())) {
        Spacer(modifier = Modifier.size(30.dp))
        AsyncImage(model = jugadores.jugadores[Id].portada, contentDescription ="Portada",
            modifier=Modifier.size(300.dp))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Informacion",textAlign= TextAlign.Left, textDecoration = TextDecoration.Underline,)
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = jugadores.jugadores[Id].info,textAlign= TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .width(30.dp)
                .padding(top = 10.dp, end = 50.dp, start = 50.dp))
    }
}