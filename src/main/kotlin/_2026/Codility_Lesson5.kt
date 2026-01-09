package _2026

import kotlin.math.max

fun main() {
    println(solution(intArrayOf(0, 1, 0, 1, 1)))
}

fun solution(A: IntArray): Int {
    var east = 0L
    var result = 0L

    for (x in A) {
        if (x == 0) {
            ++east
        } else {
            result += east
            if (result > 1000000000) return -1
        }
    }

    return result.toInt()
}

fun legacy(A: IntArray): Int {
    var result = 0L

    for (idx in 0 until A.size - 1) {
        if (A[idx] == 1) continue
        for (j in idx + 1 until A.size) {
            if (A[j] == 1) {
                ++result
                if (result > 1000000000) return -1
            }
        }
    }
    return result.toInt()
}