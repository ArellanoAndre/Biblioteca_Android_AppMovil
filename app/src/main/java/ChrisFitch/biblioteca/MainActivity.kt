package ChrisFitch.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ChrisFitch.biblioteca.domain.BooksDummy
import ChrisFitch.biblioteca.ui.screens.BookDetailScreen
import ChrisFitch.biblioteca.ui.screens.BookListScreen
import ChrisFitch.biblioteca.ui.theme.BibliotecaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BibliotecaTheme {
                val dummy = BooksDummy()
                val bookList = dummy.showAllBooks()

                var selectedBookId by remember { mutableStateOf<Int?>(null) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

                        if (selectedBookId == null) {
                            BookListScreen(
                                books = bookList,
                                onNavigationDetail = { id ->
                                    selectedBookId = id
                                }
                            )
                        } else {
                            val selectedBook = dummy.getBook(selectedBookId!!)
                            BookDetailScreen(
                                book = selectedBook,
                                onBack = {
                                    selectedBookId = null
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}