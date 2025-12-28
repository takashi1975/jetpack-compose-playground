package jp.co.example.jetpackcomposeplayground.lessons.lesson02

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


/**
 * Lesson2
 * Snackbar のテスト
 */
@Composable
fun SnackbarScreen() {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var countDismissed by remember { mutableIntStateOf(0) }
    var countPerformed by remember { mutableIntStateOf(0) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { _ ->

        Column() {
            //Test1: 表示のみ
            Button(
                onClick = {
                    //Snackbar「表示 → 消える」までを管理
                    scope.launch {
                        //showSnackbar() は suspend関数
                        snackbarHostState.showSnackbar(
                            message = "テストです",
                            //actionLabel = null,
                            duration = SnackbarDuration.Short,
                        )
                    }
                }
            ) {
                Text("SnackBar Test 1")
            }

            //Test2:
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "結果を取得(多分 Indefinite)",
                            actionLabel = "Action",
                        )
                    }
                }
            ) {
                Text("SmackBar Test 2")
            }

            //Test3:
            Button(
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "結果を取得する(Shortを指定)",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Short,
                        )

                        android.util.Log.d("test", "SnackbarResult: $result")
                        when (result) {
                            SnackbarResult.ActionPerformed -> countPerformed++
                            SnackbarResult.Dismissed       -> countDismissed++
                        }
                    }
                }
            ) {
                Text( "SnackBar Test 3: performed:$countPerformed, dismissed:$countDismissed")
            }
        }
    }
}
