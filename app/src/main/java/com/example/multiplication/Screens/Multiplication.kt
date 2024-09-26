package com.example.multiplication.Screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun show(navCOntroller: NavController) {
    Row() {
        Text(text = "hello i am navigated")
    }
}
