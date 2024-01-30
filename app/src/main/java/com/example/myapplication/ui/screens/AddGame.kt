package com.example.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ImageSearch
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddGame(){
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextTitle()
        Spacer(modifier = Modifier.height(14.dp))
        ImageGame()
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldNameGame()
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldNameTeamDevelopment()
        Spacer(modifier = Modifier.height(14.dp))
        TextFieldDate()
        Spacer(modifier = Modifier.height(14.dp))
        MyDropDownMenuType()
        Spacer(modifier = Modifier.height(14.dp))
        MyDropDownMenuAge()
        Spacer(modifier = Modifier.height(14.dp))
        MyButton()
    }
}

@Composable
fun TextTitle(){
    Text(text = "Añadir juego", fontSize = 22.sp, fontStyle = FontStyle.Italic)
}

@Composable
fun TextFieldNameGame(){
    var myText: String by remember { mutableStateOf("") }
    OutlinedTextField(value = myText,
        onValueChange = {myText = it},
        label = { Text(text = "Nombre del videojuego")})
}

@Composable
fun TextFieldNameTeamDevelopment(){
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(value = myText,
        onValueChange = {myText = it},
        label = { Text(text = "Nombre del estudio")})
}

@Composable
fun TextFieldDate(){
    var myDate by remember { mutableStateOf("") }
    OutlinedTextField(value = myDate,
        onValueChange = {myDate = it},
        label = { Text(text = "Fecha de lanzamiento")})
}

@Composable
fun ImageGame(){
    Image(Icons.Outlined.ImageSearch, contentDescription = "Buscar imagen", modifier = Modifier.size(150.dp, 150.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenuType() {
    val typeGames = listOf("Acción",
        "Aventura",
        "Disparos en primera persona",
        "Disparos en tercera persona",
        "Sigilo",
        "Deportes",
        "Estrategia en tiempo real",
        "Estrategia por turnos",
        "Rol",
        "Simulación de vida",
        "Simulación de construcción",
        "Simulación de negocios",
        "Simulación de vuelo",
        "Simulación de conducción",
        "Simulación deportiva",
        "Carreras",
        "Lucha",
        "Arcade",
        "Plataforma",
        "Puzles",
        "Horror",
        "Survival Horror",
        "Mundo abierto",
        "Multijugador masivo en línea",
        "Música y ritmo",
        "Educativo",
        "Familiar",)
    var contenidoEditText by remember { mutableStateOf(typeGames[0]) }
    var expanded by remember { mutableStateOf(false) }

    Column{
        //Este es un contenedor que proporciona la caja del menú desplegable. El contenido dentro
        //de este bloque se mostrará como el área principal del menú desplegable.
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            //Este es un componente de campo de texto que muestra el valor seleccionado actualmente
            //y actúa como el botón principal para abrir o cerrar el menú desplegable. La propiedad
            //trailingIcon se utiliza para mostrar un ícono que indica el estado del menú
            //desplegable (abierto o cerrado).
            TextField(
                value = contenidoEditText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            //Este es el componente real del menú desplegable. Se muestra solo cuando expanded es
            //true. Contiene DropdownMenuItem para cada elemento en generoJuegos.
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                //generoJuegos.forEach { item -> ... }: Un bucle que itera sobre cada elemento en
                //generoJuegos para construir las opciones del menú desplegable.
                typeGames.forEach { item ->
                    //DropdownMenuItem { ... }: Cada elemento del menú desplegable. El bloque
                    //text contiene el contenido del elemento (en este caso, un Text con el texto
                    //del juego), y onClick se ejecuta cuando se selecciona ese elemento. En este
                    //caso, actualiza contenidoEditText y cierra el menú desplegable.
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            contenidoEditText = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenuAge() {
    val ageGames = listOf("Para todos (E)",
        "Mayores de 10 años (E10+)",
        "Mayores de 13 años (T)",
        "Mayores de 17 años (M)",
        "Adultos (AO)",)
    var contenidoEditText by remember { mutableStateOf(ageGames[0]) }
    var expanded by remember { mutableStateOf(false) }

    Column{
        //Este es un contenedor que proporciona la caja del menú desplegable. El contenido dentro
        //de este bloque se mostrará como el área principal del menú desplegable.
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            //Este es un componente de campo de texto que muestra el valor seleccionado actualmente
            //y actúa como el botón principal para abrir o cerrar el menú desplegable. La propiedad
            //trailingIcon se utiliza para mostrar un ícono que indica el estado del menú
            //desplegable (abierto o cerrado).
            TextField(
                value = contenidoEditText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )
            //Este es el componente real del menú desplegable. Se muestra solo cuando expanded es
            //true. Contiene DropdownMenuItem para cada elemento en generoJuegos.
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                //generoJuegos.forEach { item -> ... }: Un bucle que itera sobre cada elemento en
                //generoJuegos para construir las opciones del menú desplegable.
                ageGames.forEach { item ->
                    //DropdownMenuItem { ... }: Cada elemento del menú desplegable. El bloque
                    //text contiene el contenido del elemento (en este caso, un Text con el texto
                    //del juego), y onClick se ejecuta cuando se selecciona ese elemento. En este
                    //caso, actualiza contenidoEditText y cierra el menú desplegable.
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            contenidoEditText = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MyButton(){
    Button(onClick = { /*TODO*/ },
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(text = "Añadir juego")
    }
}

@Preview(device = "id:pixel_7_pro")
@Composable
fun MyPreview(){
    AddGame()
}