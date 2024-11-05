package e_aloha.week6

/**
 * https://www.acmicpc.net/problem/9461
 * 파도반 수열
 *
 * N = (N-1) + (N-5)
 * N-5 이기 떄문에 N > 5
 */
fun main() = with(System.`in`.bufferedReader()) {
    val time = readLine().toInt()
    val arr = LongArray(101) { 0L }

    arr[1] = 1
    arr[2] = 1
    arr[3] = 1
    arr[4] = 2
    arr[5] = 2

    for (i in 6..100) {
        arr[i] = arr[i - 1] + arr[i - 5]
    }

    repeat(time) {
        val number = readLine()!!.toInt()
        println(arr[number])
    }
}



