package e_aloha.week3

/**
 * 5rh
 * https://www.acmicpc.net/problem/1541
 */

fun main() = with(System.`in`.bufferedReader()) {
    val expression = readLine()!!

    /**
     * 순서 대로 빼는 것 보다 한 번에 큰 수를 뺴도록 괄호를 쳐준다
     */

    // '-'를 기준으로 분리
    val splitMinus = expression.split("-")

    // 첫 번째 그룹은 무조건 더함
    var result = splitMinus[0].split("+").sumOf { it.toInt() }

    // 나머지 그룹들은 모두 빼기
    for (i in 1 until splitMinus.size) {
        result -= splitMinus[i].split("+").sumOf { it.toInt() }
    }

    println(result)
}
