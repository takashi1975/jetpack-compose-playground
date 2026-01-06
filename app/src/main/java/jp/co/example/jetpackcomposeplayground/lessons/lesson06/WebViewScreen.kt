package jp.co.example.jetpackcomposeplayground.lessons.lesson06

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun WebViewScreen(
    url: String
) {
    var isLoading by remember { mutableStateOf(false) }

    val webViewClient = remember {
        object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                android.util.Log.d("test", "WebView onPageStarted")
                isLoading = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                android.util.Log.d("test", "WebView onPageFinished")
                isLoading = false
            }
        }
    }

    Box {
        AndroidView(
            factory = { context ->
                WebView(context).apply {

                    with(settings) {
                        this.javaScriptEnabled = true
                        this.domStorageEnabled = true
                    }

                    this.webViewClient = webViewClient

                    loadUrl(url)
                }
            }
        )

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
