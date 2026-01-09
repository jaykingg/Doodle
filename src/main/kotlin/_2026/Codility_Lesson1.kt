package _2026

import kotlin.math.max

fun main() {
    println(solution(1041))
}

fun solution(N: Int): Int {
    var value = N
    var result = 0
    var current = 0
    var flag = false

    while (value > 0) {
        if ((value and 1) == 1) {
            if (flag) result = max(result, current)
            flag = true
            current = 0
        } else {
            if (flag) ++current
        }
        value = value ushr 1
    }

    return result
}