package f_grammar.domain

import java.time.Instant

data class Book(
    val id: Long,
    val name: String,
    var author: String,
    val description: String,
    val barcode: String? = null,
    val subBarcode: String? = null,
    val createAt: Instant? = Instant.now(),
    val updateAt: Instant? = null
) {
    companion object {
        // Factory method
        fun of(
            id: Long,
            name: String,
            author: String,
            description: String,
            barcode: String,
        ): Book {
            return Book(
                id, name, author, description, barcode
            )
        }
    }
}
