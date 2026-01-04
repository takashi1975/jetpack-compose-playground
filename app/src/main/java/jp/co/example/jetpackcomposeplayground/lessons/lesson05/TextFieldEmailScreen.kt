package jp.co.example.jetpackcomposeplayground.lessons.lesson05

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


/**
 * TextField Sample
 * メールアドレス入力例
 *   + 1行入力
 *   + ラベルとアイコン
 *   + メール入力用キーボード
 *   + Doneでキーボードを閉じる
 *   + フォーカスがない時に入力チェック
 *   + エラーのメッセージ表示
 */
@Composable
fun TextFieldEmailScreen() {

    var email by remember { mutableStateOf("") }
    var hasFocus by remember { mutableStateOf(false) }

    val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    val isError = !hasFocus && email.isNotEmpty() && !EMAIL_REGEX.matches(email)

    //キーボード
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },

        singleLine = true,

        label = { Text("メールアドレス") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
            )
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                //キーボードを閉じる
                focusManager.clearFocus()
                //keyboardController?.hide()
            }
        ),

        //エラー用
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = "メールアドレスが正しくありません",
                    color = MaterialTheme.colorScheme.error,
                )
            }
        },

        //フォーカスの状態
        modifier = Modifier
            .padding(8.dp)
            .onFocusChanged { focusState ->
                hasFocus = focusState.isFocused
            },
    )
}
