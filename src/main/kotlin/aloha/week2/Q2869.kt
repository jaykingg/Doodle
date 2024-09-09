package aloha

/**
 * https://www.acmicpc.net/problem/2869
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (up, down, height) = readLine()!!.split(" ").map { it.toInt() }
    var day = 0
    day = (height - down) / (up - down)

    if ((height - down) % (up - down) > 0) day++
    println(day)

//    while (true) {
//        day++
//        height -= up
//        if (height <= 0) break
//        height += down
//    }
//    println(day)
}

