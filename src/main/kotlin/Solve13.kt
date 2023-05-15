import java.lang.Integer.min

class Solve13 {
    fun main() {
        val nmr = readln().split(" ")
        val n = nmr[0].toInt()
        val m = nmr[1].toInt()
        var r = nmr[2].toInt()

        var map = Array(n){IntArray(m){0}}

        for(i in map.indices) {
            val line = readln().split(" ")
            for(j in map[0].indices) {
                map[i][j] = line[j].toInt()
            }
        }

        repeat(r) {
            val cycle = min(n, m) / 2
            val tmp = Array(n) { IntArray(m) { 0 } }
            for (i in 0 until cycle) {
                val nMax = n - i - 1
                val mMax = m - i - 1

                val tmpStart = map[i][i]
                // left
                for (k in i until mMax) tmp[i][k] = map[i][k + 1]

                // up
                for (k in i until nMax) tmp[k][mMax] = map[k + 1][mMax]

                // right
                for (k in mMax downTo i + 1) tmp[nMax][k] = map[nMax][k - 1]

                // down
                for (k in nMax downTo i + 1) tmp[k][i] = map[k - 1][i]

                tmp[i + 1][i] = tmpStart
            }
            map = tmp
        }

        map.forEach {
            println(it.joinToString(" "))
        }
    }
}