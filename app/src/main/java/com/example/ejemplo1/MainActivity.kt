package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                VistaPrevia()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    PantallaPrincipal()
}

@Composable
fun PantallaPrincipal() {
    var valor1 by remember { mutableStateOf(TextFieldValue("")) }
    var valor2 by remember { mutableStateOf(TextFieldValue("")) }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.math),
            contentDescription = "Math Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = valor1,
            onValueChange = { valor1 = it },
            label = { Text("Valor 1") },
            placeholder = { Text("Ingrese el primer valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = valor2,
            onValueChange = { valor2 = it },
            label = { Text("Valor 2") },
            placeholder = { Text("Ingrese el segundo valor") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val num1 = valor1.text.toDoubleOrNull() ?: 0.0
                val num2 = valor2.text.toDoubleOrNull() ?: 0.0
                resultado = "Resultado: ${num1 + num2}"
            }
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (resultado.isNotEmpty()) {
            Text(text = resultado, fontSize = 20.sp)
        }
    }
}
