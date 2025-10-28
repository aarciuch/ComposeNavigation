package com.example.composenavigation.forms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Param(param1: String, param2: Int) {
    Text("Otrzymano:\nparam1 = $param1\nparam2 = ${param2}")
}