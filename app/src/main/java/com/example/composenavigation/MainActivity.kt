package com.example.composenavigation

import AddScreen
import PersonList
import Screens
import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composenavigation.forms.Param
import com.example.composenavigation.ui.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    var personList : MutableList<Persons> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personList += Persons("Artur", 50)
        personList += Persons("Aga", 47)
        personList += Persons("Wera", 22)
        personList += Persons("Bartek", 19)
        personList += Persons("Grześ", 11)
        //enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
                RootNav(
                    persons = personList
                )
            }
        }
    }
}


@Composable
fun RootNav(persons: MutableList<Persons>) {
    val navController = rememberNavController()
    NavHost(navController = navController,
            startDestination = Screens.PersonList.name
    ) {
        composable(Screens.PersonList.name) {
            PersonList(navController, persons)
        }
        composable(Screens.AddScreen.name) {
            AddScreen(navController, persons)
        }
        composable("${Screens.Param.name}/{param1}/{param2}",
                    arguments = listOf(navArgument("param1") {type = NavType.StringType},
                        navArgument(name = "param2") {type = NavType.IntType})
        ) {
            val arg1 = it.arguments?.getString("param1") ?: ""
            val arg2 = it.arguments?.getInt("param2") ?: 0
            Param(arg1, arg2)
        }
    }
}