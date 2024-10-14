import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigation.Persons

@Composable
fun PersonList(navController: NavController, persons: MutableList<Persons>, modifier: Modifier = Modifier) {
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
                Text(text="Delete")
            }
        }
    }



}