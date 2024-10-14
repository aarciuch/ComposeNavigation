package com.example.composenavigation

import AddScreen
import PersonList
import Screens
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootNav(
                        modifier = Modifier.padding(innerPadding),
                        navController = rememberNavController(),
                        persons = personList
                    )
                }
            }
        }
    }
}

@Composable
fun RootNav(modifier: Modifier,
            navController: NavHostController,
            startDestination : String = Screens.PersonList.name,
            persons: MutableList<Persons>
            ) {
    NavHost(navController = navController,
        startDestination = startDestination) {
        composable(route = Screens.PersonList.name ) {
            PersonList(navController,persons)
        }
        composable(route = Screens.AddScreen.name) {
            AddScreen(navController, persons)
        }
    }
}