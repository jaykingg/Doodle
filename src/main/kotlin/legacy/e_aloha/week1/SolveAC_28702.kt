package legacy.e_aloha.week1

/**
 * https://www.acmicpc.net/problem/28702
 */
fun main() = with(System.`in`.bufferedReader()) {
    var value = 0
    for (i in 0 until 3) {
        try {
            val n = readLine().toInt()
            value = when (i) {
                0 -> n + 3
                1 -> n + 2
                2 -> n + 1
                else -> -1
            }
            break
        } catch (e: NumberFormatException) {
            continue
        }
    }

    println(
        when {
            value % 15 == 0 -> ""
            value % 5 == 0 -> ""
            value % 3 == 0 -> ""
            else -> "$value"
        }
    )
}
