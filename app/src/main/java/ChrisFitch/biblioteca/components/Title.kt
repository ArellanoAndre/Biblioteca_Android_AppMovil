package ChrisFitch.biblioteca.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookTitle(title: String, modifier: Modifier = Modifier){
    Text(title)
}