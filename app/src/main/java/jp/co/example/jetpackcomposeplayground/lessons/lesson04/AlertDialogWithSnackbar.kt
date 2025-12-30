package jp.co.example.jetpackcomposeplayground.lessons.lesson04

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

/**
 * Lesson4-3
 * AlertDialog+Snackbar Test (特に問題はなさそう)
 */
@Composable
fun AlertDialogWithSnackbar() {

    var showDialog by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true

                    //特に問題はない様子
                    scope.launch {
                        snackbarHostState.showSnackbar("Snackbar Test")
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues = padding)) {
            Text("Contents")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false

                        scope.launch {
                            //delay(100)
                            snackbarHostState.showSnackbar("Snackbar 表示しました", actionLabel = "DONE")
                        }
                    }
                ) { Text("はい") }
            },
            title = { Text("AlertDialog テスト 3") },
            text = { Text("Snackbar を表示しますか?") }
        )
    }
}
