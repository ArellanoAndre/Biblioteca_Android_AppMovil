package ChrisFitch.biblioteca.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookAuthor(author: String, modifier: Modifier = Modifier){
    Text(author)
}