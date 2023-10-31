class KySolve2 {
    fun main() {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        var maxLength = 0

        for (n in a..b) {
            val length = calculateCycleLength(n)
            maxLength = maxOf(maxLength, length)
        }

        println(maxLength)
    }

    fun calculateCycleLength(n: Int): Int {
        var current = n
        var length = 1

        while (current != 1) {
            if (current % 2 == 0) {
                current /= 2
            } else {
                current = current * 3 + 1
            }
            length++
        }
        return length
    }
}