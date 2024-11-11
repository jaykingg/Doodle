package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/5430
 * AC
 *
 * hint : flag 를 사용한다.
 * 실제로 매번 뒤집는 것은 매우 비효율 적이므로 flag 를 사용한다.
 */
fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine().toInt()

    repeat(case) {
        val p = readLine()
        val n = readLine().toInt()
        val arr =
            readLine().trim('[').trim(']').split(",").filter { it.isNotEmpty() }.map { it.toInt() }
                .toMutableList()

        var flag = false
        var isError = false

        for (code in p) {
            when (code) {
                'R' -> flag = !flag
                'D' -> {
                    if (arr.isEmpty()) {
                        isError = true
                        break
                    } else {
                        if (flag) arr.removeLast() else arr.removeFirst()
                    }
                }
            }
        }

        if (isError) {
            println("error")
        } else {
            val result = if (flag) arr.reversed() else arr
            println(result.joinToString(",", "[", "]"))
        }
    }
}
