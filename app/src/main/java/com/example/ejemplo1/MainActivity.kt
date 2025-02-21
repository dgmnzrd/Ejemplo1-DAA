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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

// Práctica 3
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
    var precio by remember { mutableStateOf(TextFieldValue("")) }
    var descuento by remember { mutableStateOf(TextFieldValue("")) }
    var descuentoAplicado by remember { mutableStateOf("") }
    var precioFinal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.ecommerce_purple),
            contentDescription = "E-Commerce Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio ($)") },
            placeholder = { Text("Ingrese el precio del producto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = { Text("Descuento (%)") },
            placeholder = { Text("Ingrese el descuento del producto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val pre = precio.text.toDoubleOrNull() ?: 0.0
                val desc = descuento.text.toDoubleOrNull() ?: 0.0
                val descAplicado = (pre * desc / 100).toString()
                val preFinal = (pre - (pre * desc / 100)).toString()

                descuentoAplicado = "Descuento aplicado: $descAplicado"
                precioFinal = "Precio final: $preFinal"
            }
        ) {
            Text("Aplicar descuento")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (precioFinal.isNotEmpty()) {
            Text(text = descuentoAplicado, fontSize = 20.sp)
            Text(text = precioFinal, fontSize = 20.sp)
        }
    }
}