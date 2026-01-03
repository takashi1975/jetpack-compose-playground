package jp.co.example.jetpackcomposeplayground.lessons.lesson05

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

/**
 * Lesson5
 * TextFieldの練習
 */
@Composable
fun TextFieldBasicsScreen() {
    var text by remember { mutableStateOf("") }

    Column() {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("TextField練習") }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("OutlinedTextField練習")}
        )

        BasicTextField(
            value = text,
            onValueChange = { text = it }
        )
    }
}
