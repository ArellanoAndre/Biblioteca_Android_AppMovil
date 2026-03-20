package ChrisFitch.biblioteca.ui.screens

import ChrisFitch.biblioteca.components.Book
import ChrisFitch.biblioteca.ui.theme.DarkBlue
import ChrisFitch.biblioteca.ui.theme.OrangeCool
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookCard(title: String,
             author: String,
             genre: String,
             description: String,
             pages: Int,
             available: Boolean,
             image: Int){
    Box(contentAlignment = Alignment.TopCenter){
        Image(
            painter = painterResource(image),
            contentDescription = title,
            contentScale = ContentScale.Fit
        )
        Row() {
            Column() {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    book: Book
    ) {
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
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    BookDetailScreen()
}