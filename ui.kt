package com.example.corrutinas_rec

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * variable global
 */
// para crear los objetos de las frases
data class Frase(var texto: String, var verdadero: Boolean)
// lista para almacenar las frase
var frases: MutableList<Frase> = mutableListOf()
// la frase actual
var fraseActual: MutableState<Frase> = mutableStateOf(Frase("-",true))
// la cuenta atras
var cuentaAtras: MutableState<Int> = mutableStateOf(20)
var puntuacion: MutableState<Int> = mutableStateOf(0)
var state: State = State.WAITING

/**
 * estados del juego
 */
enum class State {
    // PLAYING es que se le ha dado al start
    PLAYING, WAITING
}

/**
 * utilización dentro de un función composable cualquiera
 */
fun aux(){
    // introducir frases en la lista
    frases.add(Frase("el torneo de rugby cinco naciones, ahora es seis naciones",true))
    frases.add(Frase("en el cielo hay cinco estrellas",false))
    frases.add(Frase("el dia cinco de diciembre del 2023 es martes",true))
    frases.add(Frase("cinco más cinco son diez",true))
    frases.add(Frase("dos mas dos son cinco",false))
    frases.add(Frase("los elefantes tienen cinco patas",false))
    frases.add(Frase("las estaciones climáticas son cinco",false))
    frases.add(Frase("tenemos cinco dedos los humanos",true))
    frases.add(Frase("cinco días tiene la semana sin el Domingo y el Sábado",true))
    frases.add(Frase("una gallina pesa menos que cinco toneladas",true))

    // asignar una frase aleatoria
    fraseActual.value = frases.random()

}

// estructura view + funcionalidad
@Composable
fun UserInterface(){
    Column {
        botonStart()
        // cuentaAtras()
        // fraseVF()
        // puntuacion()
    }
}

// crea el boton start
@Composable
fun botonStart(){
    // para crear el objeto que nos permite hacer una corrutina
    val iuScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(0.dp, 20.dp, 0.dp, 50.dp)
    ) {
        Button(
            onClick = {
                // para que solo se pueda dar al boton una vez
                if(state == State.WAITING){
                    // reiniciar la cuenta atras y la puntuacion
                    cuentaAtras.value = 20
                    puntuacion.value = 0
                    // iniciar la cuenta atras
                    iuScope.launch {
                        state = State.PLAYING
                        while (cuentaAtras.value > 0){
                            delay(1000)
                            cuentaAtras.value -= 1
                        }
                        state = State.WAITING
                    }
                    aux()
                }
            }
        ) {
            Text(text = "Start")
        }
    }
}

// Crea el texto de la cuenta atras y el numero de la cuenta atras
@Composable
fun cuentaAtras(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
    ) {
        Text(text = "Cuenta atras:")
    }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(0.dp, 0.dp, 0.dp, 50.dp)
    ){
        Text(
            text = cuentaAtras.value.toString(),
            fontSize = 50.sp
        )
    }
}
