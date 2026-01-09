package _2026

fun main() {
    solution1(intArrayOf(1, 3, 6, 4, 1, 2))
}

fun solution1(A: IntArray): Int {
    val distinctArray = A.distinct().sorted()

    for (i in 0 until distinctArray.size) {
        if (distinctArray[i] != i + 1) {
            println(i + 1)
        }
    }

    return 0
}