package jp.co.example.jetpackcomposeplayground.lessons.lesson01

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@Composable
fun ButtonCounterScreen() {

    val context = LocalContext.current

    Button(onClick = {
        Toast.makeText(context, "Hello world", Toast.LENGTH_SHORT).show()
    }) {
        Text(text="ボタンです")
    }
}
