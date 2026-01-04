package jp.co.example.jetpackcomposeplayground.lessons.lesson05

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Lesson5
 * TextFieldの練習
 */
@Composable
fun TextFieldBasicsScreen() {
    var text by rememberSaveable { mutableStateOf("") }
    val textFieldState = rememberTextFieldState("test")

    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                //shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val titleModifier = Modifier.width(120.dp)

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("TextField", modifier = titleModifier)
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TextField練習") }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("OutlinedTextField", modifier = titleModifier)
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("OutlinedTextField練習") }
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("BasicTextField", modifier = titleModifier)
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("BasicTextField\n(by state)", modifier = titleModifier)
            BasicTextField(
                state = textFieldState,
                modifier = Modifier.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
            )
        }
    }
}
