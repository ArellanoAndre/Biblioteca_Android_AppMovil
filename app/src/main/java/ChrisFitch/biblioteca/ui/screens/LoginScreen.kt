package ChrisFitch.biblioteca.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ChrisFitch.biblioteca.R
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import ChrisFitch.biblioteca.ui.theme.DarkBlue
import ChrisFitch.biblioteca.ui.theme.LilPurple
import ChrisFitch.biblioteca.ui.theme.OrangeCool
import ChrisFitch.biblioteca.ui.theme.Purple40
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen(onLoginSuccess: () -> Unit,
                   onBackToRegister: () -> Unit){

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.
            fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(R.drawable.libroslogo),
            contentDescription = "logo",
            modifier = Modifier
                .size(150.dp)
                .padding(15.dp)
        )

        Text("Biblioteca Sonora",
            style = MaterialTheme.typography.headlineLarge,
            color = DarkBlue,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp
        )

        Text("Inicio de Sesion",
            style = MaterialTheme.typography.headlineLarge,
            color = DarkGray,
            lineHeight = 50.sp
        )

        Spacer(modifier = Modifier.height(60.dp))

        var textState by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nombre de Usuario") },
            modifier = Modifier.fillMaxWidth(), // Ancho total
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(160.dp))

        Button(onClick = onLoginSuccess, modifier = Modifier.fillMaxWidth()) {
            Text("Iniciar Sesion",
                fontSize = 18.sp)
        }

        TextButton(onClick = onBackToRegister) {
            Text("No tengo cuenta",
                color = Purple40,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(onLoginSuccess = {}, onBackToRegister = {})
}