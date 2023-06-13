import java.lang.Math.abs
import java.lang.Math.min

/*
    https://www.acmicpc.net/problem/2564
    경비원
 */
class Solve16 {
    fun main() {
        val (row, col) = readln().split(" ").map { it.toInt() +1 }
        val total = (row + col - 2) * 2
        val stores = readln().toInt()
        val map = makeMap(col,row)
        val storesPoint = mutableListOf<Pair<Int,Int>>()
        var result = 0
        for(i in 0 until stores+1) {
            val (d, dc) = readln().split(" ").map { it.toInt() }
            if(i != stores) {
                storesPoint.add(Pair(d, dc))
            }
            else {
                val (manCol, manRow) = switchDirectionToPoint(Pair(d,dc),map)
                storesPoint.forEach {
                    val (storeCol, storeRow) = switchDirectionToPoint(Pair(it.first,it.second),map)
                    val t = (total) - abs(map[storeCol][storeRow] - map[manCol][manRow])
                    val tt = abs(map[storeCol][storeRow] - map[manCol][manRow])
                    result += min((total - abs(map[storeCol][storeRow] - map[manCol][manRow])), abs(map[storeCol][storeRow] - map[manCol][manRow]))
                }
            }
        }

        println(result)

    }

    fun makeMap(col: Int, row: Int) : Array<IntArray> {
        val map = Array(col) { IntArray(row) { 0 } }

        for(i in map[0].indices) {
            map[0][i] = i + 1
        }

        for(i in 0 until map.size-1) {
            map[i+1][map[0].size-1] = map[i][map[0].size-1] + 1
        }

        for(i in map[0].size-1 downTo 1) {
            map[map.size-1][i-1] = map[map.size-1][i] + 1
        }

        for(i in map.size-2 downTo 1) {
            map[i][0] = map[i+1][0] + 1
        }

        return map
    }

    fun switchDirectionToPoint(storePoint: Pair<Int,Int>, map: Array<IntArray>) : Pair<Int,Int> {
        when(storePoint.first) {
            1 -> return Pair(0,storePoint.second)
            2 -> return Pair(map.size-1,storePoint.second)
            3 -> return Pair(storePoint.second,0)
            4-> return Pair(storePoint.second,map[0].size-1)
        }
        return Pair(0,0)
    }
}