import android.R.attr.name
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigation.Persons
import kotlin.random.Random


@Composable
fun PersonList(navController: NavController, persons: MutableList<Persons>, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {},
        bottomBar = {PasekDolny(navController)},
        content = {paddingValues -> Zawartosc(navController, persons, modifier = modifier.padding(paddingValues))}
    )
}

@Composable
fun Zawartosc(navController: NavController, persons: MutableList<Persons>, modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(0) }
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        item {
            Text(text = "Persons List")
        }
        item {
            Button(
                onClick = {
                    navController.navigate(route = Screens.AddScreen.name)
                })
            {
                Text(text = "Go to Add Screen")
            }
        }
        itemsIndexed(items = persons) { i, person ->
            Text(text = "${person.name}, ${person.age}")
            Button(onClick = {
                index = i
                persons.removeAt(index)
                navController.navigate(route = Screens.PersonList.name)
            })
            {
                Text(text="Delete person")
            }
        }
    }
}

@Composable
fun PasekDolny(navController: NavController) {
    Row(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Cyan),
        Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = {navController.navigate(Screens.PersonList.name)}
        ) {
            Icon(imageVector = Icons.Default.Home, "HOME")
        }

        IconButton(onClick = {navController.navigate(Screens.AddScreen.name)}
        ) {
            Icon(imageVector = Icons.Default.Add, "ADD")
        }

        IconButton(onClick = {navController.navigate("${Screens.Param.name}/Mirek/10")}
        ) {
            Icon(imageVector = Icons.Default.Face, "OSOBA")
        }
    }
}