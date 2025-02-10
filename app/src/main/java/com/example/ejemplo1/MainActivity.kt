package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

// Column Row Ejemplo 1 10/02/2025
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Content( "Hola ", "Mundo ")
}

@Composable
fun Content(mensaje1: String, mensaje2: String) {
    Column {
        Text(
            mensaje1,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 31.sp,
            lineHeight = 31.sp)
        Text(
            mensaje2,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 20.sp)
        Text(
            "Rede",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 20.sp)

        Row {
            Text(mensaje1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                lineHeight = 20.sp)
            Text(mensaje2,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 44.sp)
            Text("Rede",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 10.sp,
                lineHeight = 50.sp)
        }
    }
}