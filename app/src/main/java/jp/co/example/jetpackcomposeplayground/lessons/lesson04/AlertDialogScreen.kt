package jp.co.example.jetpackcomposeplayground.lessons.lesson04

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Lesson4-1
 * AlertDialog の練習
 */
@Composable
fun AlertDialogScreen() {
    //UI でフラグを切り替える
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = {
            //ダイアログを表示する
            showDialog = true
        }
    ) {
        Text("Open Dialog")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton =  { TextButton(onClick = { showDialog = false } ) { Text("はい") } },
            dismissButton =  { TextButton(onClick = { showDialog = false } ) { Text("いいえ") } },
            title = { Text("ダイアログテスト 1") },
            text = { Text("成功ですか？") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Person") },
        )
    }
}
