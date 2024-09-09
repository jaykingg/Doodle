package aloha

/**
 * https://www.acmicpc.net/problem/2751
 */

fun main() = with(System.`in`.bufferedReader()) {
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
