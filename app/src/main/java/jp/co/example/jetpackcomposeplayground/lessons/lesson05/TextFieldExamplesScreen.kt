package jp.co.example.jetpackcomposeplayground.lessons.lesson05

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


/**
 * Lesson5
 * TextFieldの練習2
 */
@Composable
fun TextFieldExamplesScreen() {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var text1 by rememberSaveable { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    var text3 by rememberSaveable { mutableStateOf("") }
    var text4 by rememberSaveable { mutableStateOf("") }

    var keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { padding ->

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            //文字数制限
            OutlinedTextField(
                value = text1,
                onValueChange = {
                    if (it.length <= 10) {
                        text1 = it
                    }
                },
                label = { Text("10文字までの制限例") }
            )

            //入力フィルタ
            OutlinedTextField(
                value = text2,
                onValueChange = {
                    if (it.all { c -> c.isDigit() }) {
                        text2 = it
                    }
                },
                label = { Text("数字のみの入力制限例") }
            )

            //キーボード指定
            OutlinedTextField(
                value = text3,
                onValueChange = { text3 = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                ),
                label = { Text("KeyboardOptions: 数値入力") }
            )

            //IMEアクション
            OutlinedTextField(
                value = text4,
                onValueChange = { text4 = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        scope.launch {
                            snackbarHostState.showSnackbar("keyboard done")
                        }

                        keyboardController?.hide()
                    }
                ),
                label = { Text("KeyboardActions") }
            )
        }
    }
}
