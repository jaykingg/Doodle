package legacy.b_boj

import java.lang.Integer.min
import java.util.StringTokenizer

/*
    RGB 거리
    https://www.acmicpc.net/problem/1149
 */
class SolveAC_1149 {
    fun main() {
        val n = readln().toInt()
        if (n < 2 || n > 1000) return

        val arr = Array(n) { IntArray(3) { 0 } }
        val line = StringTokenizer(readlnOrNull())
        arr[0][0] = line.nextToken().toInt()
        arr[0][1] = line.nextToken().toInt()
        arr[0][2] = line.nextToken().toInt()

        repeat(n - 1) {
            val nLine = StringTokenizer(readlnOrNull())
            arr[it + 1][0] = min(arr[it][1], arr[it][2]) + nLine.nextToken().toInt()
            arr[it + 1][1] = min(arr[it][0], arr[it][2]) + nLine.nextToken().toInt()
            arr[it + 1][2] = min(arr[it][0], arr[it][1]) + nLine.nextToken().toInt()
        }

        println(min(min(arr[n - 1][0], arr[n - 1][1]), min(arr[n - 1][1], arr[n - 1][2])))
    }
}
