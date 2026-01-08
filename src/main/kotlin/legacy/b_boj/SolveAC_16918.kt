package legacy.b_boj

import java.util.LinkedList

class SolveAC_16918 {
    /*
        https://www.acmicpc.net/problem/16918
     */
    fun main() {
        val (R, C, N) = readln().split(" ").map { it.toInt() }
        val map = Array(R) { Array(C) { "O" } }
        val di = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))
        val bombedMap = Array(R) { Array(C) { "O" } }
        val bombedMap2 = Array(R) { Array(C) { "O" } }
        val bombQueue = LinkedList<Pair<Int, Int>>()

        if (N % 2 == 0) {
            map.forEach {
                println(it.joinToString(""))
            }
        } else {
            for (i in map.indices) {
                val line = readlnOrNull()!!
                for (j in 0 until map[i].size) {
                    if (line[j] == '.') {
                        map[i][j] = "."
                    } else {
                        bombQueue.add(Pair(i, j))
                    }
                }
            }
        }

        if (N == 1) {
            map.forEach {
                println(it.joinToString(""))
            }
            return
        }

        while (bombQueue.isNotEmpty()) {
            val (qr, qc) = bombQueue.poll()
            for (i in di.indices) {
                val nr = qr + di[i].first
                val nc = qc + di[i].second
                if (nr > -1 && nr < map.size && nc > -1 && nc < map[0].size) {
                    bombedMap[nr][nc] = "."
                }
            }
        }

        bombQueue.clear()
        for (i in bombedMap.indices) {
            for (j in map[i].indices) {
                if (bombedMap[i][j] == "O") {
                    bombQueue.add(Pair(i, j))
                }
            }
        }

        while (bombQueue.isNotEmpty()) {
            val (qr, qc) = bombQueue.poll()
            for (i in di.indices) {
                val nr = qr + di[i].first
                val nc = qc + di[i].second
                if (nr > -1 && nr < map.size && nc > -1 && nc < map[0].size) {
                    bombedMap2[nr][nc] = "."
                }
            }
        }


        if (N % 4 == 3) {
            bombedMap.forEach {
                println(it.joinToString(""))
            }
        } else if (N % 4 == 1) {
            bombedMap2.forEach {
                println(it.joinToString(""))
            }
        }
    }

}


