package _2026

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(solution("{[()()]}"))
}

fun solution(S: String): Int {
    val varArr = S.toCharArray()
    if (varArr.size % 2 != 0) return 0

    for (i in 0 until varArr.size / 2) {
        if (varArr[i] == '(') {
            if (varArr[varArr.size - 1 - i] != ')') {
                return 0
            }
        }
        if (varArr[i] == '[') {
            if (varArr[varArr.size - 1 - i] != ']') {
                return 0
            }
        }

        if (varArr[i] == '{') {
            if (varArr[varArr.size - 1 - i] != '}') {
                return 0
            }
        }
    }
    return 1
}