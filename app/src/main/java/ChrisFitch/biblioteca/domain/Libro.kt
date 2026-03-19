package ChrisFitch.biblioteca.domain

import java.time.LocalDate

data class Libro(
    val titulo: String,
    val autor: String,
    val genero: String,
    val isbn: Integer,
    val editorial: String,
    val fechaPublicacion: LocalDate,



    )
