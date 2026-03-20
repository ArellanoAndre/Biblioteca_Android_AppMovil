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
import ChrisFitch.biblioteca.ui.theme.DarkBlue
import ChrisFitch.biblioteca.ui.theme.OrangeCool
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BookListScreen(books: List<Book>, onNavigationDetail: (id: Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Biblioteca",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                },
                actions = {
                    IconButton(onClick = { /*  */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar libro"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeCool,
                    titleContentColor = DarkBlue,
                    actionIconContentColor = DarkBlue
                )
            )
            Spacer(modifier = Modifier.height(80.dp))
        }

    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(books) { book ->
                BookGridItem(book, onNavigationDetail)
            }
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