package jp.co.example.jetpackcomposeplayground.lessons.lesson04

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * Lesson4-2
 * Scaffold で AlertDialog の確認
 */
@Composable
fun AlertDialogWithScaffoldScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(paddingValues = padding)) {
            Text("Context")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { TextButton(onClick = { showDialog = false }) { Text("はい") } },
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("いいえ") } },
            title = { Text("ダイアログテスト 2")},
            text =  { Text("成功ですか?")},
            icon = { Icon(Icons.Default.Phone, contentDescription = "Phone")}
        )
    }
}
