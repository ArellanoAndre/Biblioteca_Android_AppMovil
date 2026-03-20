package ChrisFitch.biblioteca.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ChrisFitch.biblioteca.components.Book
import ChrisFitch.biblioteca.components.borrowBook

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
                        fontSize = 20.sp
                    )
                },

                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8D6E63), // mismo login
                    titleContentColor = Color.White
                )
            )
        },

        containerColor = Color(0xFFF5EFE6)

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = book.image),
                        contentDescription = book.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = book.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2C3E50)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Autor: ${book.author}", fontSize = 16.sp)
                    Text("Género: ${book.genre}", fontSize = 16.sp)
                    Text("Páginas: ${book.pages}", fontSize = 16.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    // 🔥 Estado con color


                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Descripción",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = book.description,
                        fontSize = 15.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // 🔥 Botón principal
                    Button(
                        onClick = {
                            Toast.makeText(context, borrowBook(), Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE59866)
                        )
                    ) {
                        Text("Prestar libro", fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // 🔥 Botón secundario
                    Button(
                        onClick = { onBack() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF5D6D7E)
                        )
                    ) {
                        Text("Volver", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}