package e_aloha

/**
 * https://www.acmicpc.net/problem/15829
 */

fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 마지막 식을 구현하는 것
     * 처음엔 50점이 나왔음
     * 마지막 결과에서 mod m 을 해주어야 나머지 50도 통과 됨
     */
    val n = readLine()!!.toInt()
    val word = readLine()!!.toString()
    val r = 31
    val m = 1234567891

    var result = 0L
    var pow = 1L

    repeat(n) {
        result += (word[it] - 'a' + 1) * pow % m
        pow = (pow * r) % m
    }
    println(result % m)
}
