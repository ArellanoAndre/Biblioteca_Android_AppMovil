package ChrisFitch.biblioteca.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ChrisFitch.biblioteca.components.Book
import ChrisFitch.biblioteca.components.BookGridItem
import ChrisFitch.biblioteca.components.BooksDummy

@Composable
fun BookListScreen(books: List<Book>, onNavigationDetail: (id: Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(5.dp, 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(books) { book ->
            BookGridItem(book, onNavigationDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookListScreenPreview() {
    val dummy = BooksDummy()
    BookListScreen(
        books = dummy.showAllBooks(),
        onNavigationDetail = {}
    )
}