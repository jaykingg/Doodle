package aloha.week1

/**
 * https://www.acmicpc.net/problem/1259
 */

fun main() = with(System.`in`.bufferedReader()) {

    while(true) {
        val n = readLine()!!
        if(n.toInt()==0) break

        println(if(n == n.reversed()) "yes" else "no")
    }
}
