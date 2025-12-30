package jp.co.example.jetpackcomposeplayground

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class Screen(val route: String) {
    Menu("menu"),
    //TODO: 1.レッスン名
    Lesson1("lesson 1 - Button"),
    Lesson2("Lesson 2 - Snackbar"),
    Lesson3("Lesson 3 - Scaffold"),
    Lesson4_1("Lesson 4-1 - AlertDialog"),
    Lesson4_2("Lesson 4-2 - AlertDialog with Scaffold"),
    Lesson4_3("Lesson 4-3 - AlertDialog with Snackbar")
}


@Composable
fun PlaygroundApp() {
    val navController = rememberNavController()

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->

        NavHost(
            navController,
            startDestination = Screen.Menu.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Menu.route) {
                //TODO: 2.メニューを追加
                val items = listOf(
                    Screen.Lesson1      to "Button Sample",
                    Screen.Lesson2      to "Snackbar Sample",
                    Screen.Lesson3      to "Scaffold Sample",
                    Screen.Lesson4_1    to "AlertDialog Sample1",
                    Screen.Lesson4_2    to "AlertDialog Sample2 (Scaffold)",
                    Screen.Lesson4_3    to "AlertDialog Sample3 (Snackbar)",
                )

                MenuScreen(items) { route ->
                    navController.navigate(route)
                }
            }

            //TODO: 3.レッスンへの遷移
            //Lesson 1
            composable(Screen.Lesson1.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson01.ButtonCounterScreen()
            }
            //Lesson 2
            composable(Screen.Lesson2.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson02.SnackbarScreen()
            }
            //Lesson 3
            composable(Screen.Lesson3.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson03.ScaffoldScreen()
            }
            //Lesson 4
            composable(Screen.Lesson4_1.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson04.AlertDialogScreen()
            }
            composable(Screen.Lesson4_2.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson04.AlertDialogWithScaffoldScreen()
            }
            composable(Screen.Lesson4_3.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson04.AlertDialogWithSnackbar()
            }
        }
    }
}
