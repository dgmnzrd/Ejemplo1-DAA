package com.example.ejemplo1.views

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejemplo1.components.ActionButton
import com.example.ejemplo1.components.MainButton
import com.example.ejemplo1.components.Spacers
import com.example.ejemplo1.components.TitleBar
import com.example.ejemplo1.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleBar("HomeView")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton(Color.Red)
        }
    ) {
        ContentView()
    }
}

@Preview
@Composable
private fun ContentView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TitleView("HomeView")
        Spacers()
        MainButton(name = "Genérico", backColor = Color.Red, color = Color.White) {
            Log.d( "", "Soy un botón genérico")
        }
    }
}