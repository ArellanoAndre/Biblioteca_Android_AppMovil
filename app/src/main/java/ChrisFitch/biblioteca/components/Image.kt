package ChrisFitch.biblioteca.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BookImage(image: Int, name: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = name,
        contentScale = ContentScale.Fit,
        modifier = modifier.size(80.dp)
    )
}