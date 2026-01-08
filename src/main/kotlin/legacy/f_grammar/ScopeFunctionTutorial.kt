package legacy.f_grammar

import legacy.f_grammar.domain.Book

fun main() = with(System.`in`.bufferedReader()) {
    println("------------- let -------------")
    letTrial()
    println("------------- run -------------")
    runTrial()
    println("------------- with -------------")
    withTrial()
    println("------------- apply -------------")
    applyTrial()
    println("------------- also -------------")
    alsoTrial()
    println("------------- copy -------------")
    copyTrial()
}

fun letTrial() {
    val book1 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    )

    book1.barcode?.let {
        println(it.length)
        it.length // 마지막 줄이 반환 됨
    }.also { println(it) }


    val book2 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = "a-barcode"
    )

    book2.barcode?.let {
        println(it.length)
        it.length // 마지막 줄이 반환 됨
    }.also { println(it) }
}

fun runTrial() {
    val book1 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    ).run { "$name append text" }
    println(book1)
}

fun withTrial() {
    val book1 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    )
    val result = with(book1) {
        this.copy(
            name = "with and copy name"
        )
    }
    println(result)
}

fun applyTrial() {
    val book1 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    )

    val result = book1.apply {

    }
    println(result)
}

fun alsoTrial() {
    Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    ).also { println(it) }
}

fun copyTrial() {
    val book1 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    )

    val book2 = Book.of(
        id = 1L,
        name = "a-name",
        description = "a-description",
        author = "a-author",
        barcode = null.toString()
    ).copy()

    println(book1 == book2)
    println(book1.hashCode() == book2.hashCode())

}

