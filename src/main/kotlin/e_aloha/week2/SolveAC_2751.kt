package e_aloha

/**
 * https://www.acmicpc.net/problem/2751
 */

fun main() = with(System.`in`.bufferedReader()) {
    /**
     * 정렬 문제, 입출력 제한이 있어서 append 로 처리함
     */
    val n = readLine()!!.toInt()
    val list = ArrayList<Int>()
    val builder = StringBuilder()

    repeat(n) {
        list.add(readLine()!!.toInt())
    }

    list.sort()

    for (i in list) {
        builder.append(i).append("\n")
    }
    println(builder)
}
