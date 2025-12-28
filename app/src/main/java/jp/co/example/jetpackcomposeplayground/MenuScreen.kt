package jp.co.example.jetpackcomposeplayground

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MenuScreen(
    items: List<Pair<Screen, String>>,
    onSelect: (String) -> Unit,
) {
    LazyColumn {
        items(items) { (route, label) ->
            ListItem(
                headlineContent = { Text(label) },
                modifier = Modifier
                    .clickable { onSelect(route.route) }
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            HorizontalDivider()
        }
    }
}
