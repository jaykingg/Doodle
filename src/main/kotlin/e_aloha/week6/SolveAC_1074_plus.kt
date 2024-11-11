package e_aloha.week6

import kotlin.math.pow

/**
 * https://www.acmicpc.net/problem/1074
 * Z
 *
 *
 */
fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, c) = readLine()!!.split(" ").map { it.toInt() }
    println(findZ(n, r, c))
}

fun findZ(n: Int, r: Int, c: Int): Int {
    if (n == 0) return 0

    // 2^(n-1) 크기 계산
    val half = 2.0.pow(n - 1).toInt()
    return when {
        // 2사분면
        r < half && c < half -> findZ(n - 1, r, c)

        // 1사분면
        half in (r + 1)..c -> half * half + findZ(n - 1, r, c - half)

        // 3사분면
        half in (c + 1)..r -> 2 * half * half + findZ(n - 1, r - half, c)

        // 4사분면
        else -> 3 * half * half + findZ(n - 1, r - half, c - half)
    }
}
