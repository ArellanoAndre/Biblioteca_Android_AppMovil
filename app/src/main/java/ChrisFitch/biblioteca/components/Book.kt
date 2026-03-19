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