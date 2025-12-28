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
    Lesson01("lesson 01 - Button"),
    Lesson02("Lesson 02 - Snackbar"),
    Lesson03("Lesson 03 - Scaffold")
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
                    "Button Sample"     to Screen.Lesson01,
                    "Snackbar Sample"   to Screen.Lesson02,
                    "Scaffold Sample"   to Screen.Lesson03,
                )

                MenuScreen(items) { route ->
                    navController.navigate(route)
                }
            }

            //TODO: 3.レッスンへの遷移
            //Lesson01
            composable(Screen.Lesson01.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson01.ButtonCounterScreen()
            }
            //Lesson02
            composable(Screen.Lesson02.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson02.SnackbarScreen()
            }
            //Lesson03
            composable(Screen.Lesson03.route) {
                jp.co.example.jetpackcomposeplayground.lessons.lesson03.ScaffoldScreen()
            }
        }
    }
}
