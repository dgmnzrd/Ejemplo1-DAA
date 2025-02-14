package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

// Modifiers Ejemplo 1
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
    Column {
        Content1()
        Content2()
        Content3()
        Content4()
        Content5()
    }
}

@Composable
fun Content1() {
    Text("Text with green background color",
        Modifier
            .padding(32.dp)
            .background(color = Color.Green)
    )
}

@Composable
fun Content2() {
    Text("Padding and margin!",
        color = Color.Red,
        modifier = Modifier
            .padding(32.dp)
            .background(Color.Yellow))
}

@Composable
fun Content3() {
    Text("Text with Size",
        color = Color.White,
        modifier = Modifier
            .padding(32.dp)
            .background(Color.Cyan)
            .size(width = 250.dp, height = 100.dp))
}

@Composable
fun Content4() {
    Text("Text Width Match Parent",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .padding(Dp(10f))
            .fillMaxWidth(1f))
}

@Composable
fun Content5() {
    Text("Text with 75% Height",
        color = Color.White,
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxHeight(0.75f))
}