package ChrisFitch.biblioteca.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ChrisFitch.biblioteca.components.Book
import ChrisFitch.biblioteca.components.borrowBook
import ChrisFitch.biblioteca.ui.theme.DarkBlue
import ChrisFitch.biblioteca.ui.theme.OrangeCool

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    book: Book,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del libro",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = OrangeCool,
                    titleContentColor = DarkBlue
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(id = book.image),
                        contentDescription = book.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = book.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Autor: ${book.author}", fontSize = 18.sp)
                    Text(text = "Género: ${book.genre}", fontSize = 18.sp)
                    Text(text = "Páginas: ${book.pages}", fontSize = 18.sp)
                    Text(
                        text = if (book.available) "Disponible" else "No disponible",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Descripción:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(text = book.description, fontSize = 16.sp)

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            Toast.makeText(context, borrowBook(), Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = OrangeCool)
                    ) {
                        Text("Prestar libro")
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = { onBack() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Volver")
                    }
                }
            }
        }
    }
}