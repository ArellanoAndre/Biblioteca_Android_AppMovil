package ChrisFitch.biblioteca.components

import ChrisFitch.biblioteca.R

class BooksDummy {
    val bookList = listOf(

        Book(
            title = "Cien años de soledad",
            id = 1,
            author = "Gabriel García Márquez",
            genre = "Realismo mágico",
            description = "Historia de la familia Buendía en Macondo.",
            pages = 417,
            available = true,
            image = R.drawable.cien
        ),

        Book(
            title = "Don Quijote de la Mancha",
            id = 2,
            author = "Miguel de Cervantes",
            genre = "Novela clásica",
            description = "Aventuras de un caballero que lucha contra molinos.",
            pages = 863,
            available = false,
            image = R.drawable.donquijote
        ),

        Book(
            title = "El Principito",
            id = 3,
            author = "Antoine de Saint-Exupéry",
            genre = "Fábula",
            description = "Historia sobre la amistad, el amor y la vida.",
            pages = 96,
            available = true,
            image = R.drawable.principito
        ),

        Book(
            title = "Harry Potter y la piedra filosofal",
            id = 5,
            author = "J.K. Rowling",
            genre = "Fantasía",
            description = "Un niño descubre que es mago.",
            pages = 309,
            available = true,
            image = R.drawable.harrypoter
        ),

        Book(
            title = "1984",
            id = 6,
            author = "George Orwell",
            genre = "Distopía",
            description = "Una crítica feroz a los totalitarismos y la vigilancia extrema.",
            pages = 328,
            available = true,
            image = R.drawable.milnovecientos
        ),

        Book(
            title = "El libro troll",
            id = 7,
            author = "ElRubius",
            genre = "Comedia",
            description = "Un libro muy troll con chistes y retos.",
            pages = 432,
            available = false,
            image = R.drawable.troll
        )


    )

    fun showAllBooks(): List<Book> {
        return bookList
    }

    fun getOneBook(): Book {
        return bookList.random()
    }

    fun getBook(id: Int): Book {
        return bookList.first { it.id == id }
    }
}