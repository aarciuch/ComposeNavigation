import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composenavigation.Persons

@Composable
fun AddScreen(navController: NavController,  persons: MutableList<Persons>, modifier: Modifier = Modifier) {
    var personName by rememberSaveable { mutableStateOf("") }
    var personAge by remember { mutableStateOf(0) }
    var personAgeString = remember { mutableStateOf("0") }

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp))
    {
        Row()
        {
            Text(text = "Add Screen")
        }
        Row() {
            TextField(
                value = personName,
                onValueChange = {
                    personName = it
                },
                label = { Text("person name:") }
            )
        }
        Row() {
            TextField(
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                value = personAgeString.value,
                onValueChange = {
                    if (!it.isEmpty()) {
                        personAgeString.value = it
                    }
                },
                label = { Text("person age:") }
            )
        }
        Row() {
            Button(onClick = {
                personAge = personAgeString.value.toInt()
                persons += Persons(personName,personAge)
                navController.navigate(route = Screens.PersonList.name)

            })
            {
                Text(text="Add person and go back")
            }
        }


    }

}