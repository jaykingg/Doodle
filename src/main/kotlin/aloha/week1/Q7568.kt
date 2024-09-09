package aloha.week1

/**
 * https://www.acmicpc.net/problem/7568
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list: MutableList<Pair<Int,Int>> = mutableListOf()

    repeat(n) {
        val (weight, height) = readLine()!!.split(" ").map { it.toInt() }
        list.add(Pair(weight, height))
    }



    list.forEach { based ->
        var rank = 1
        list.forEach { compared ->
            if(based.first < compared.first && based.second < compared.second) rank++
        }
        println("$rank")
    }
}
