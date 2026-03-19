package ChrisFitch.biblioteca.components

data class Book(
    val title: String,
    val id: Int,
    val author: String,
    val genre: String,
    val description: String,
    val pages: Int,
    val available: Boolean,
    val image: Int
)

fun borrowBook(): String {
    val disponible = (0..1).random() == 1

    return if (disponible) {
        "Libro prestado"
    } else {
        val dias = (1..7).random()
        "Libro no disponible. Espera $dias días"
    }
}