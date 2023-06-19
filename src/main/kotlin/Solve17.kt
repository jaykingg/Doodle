/*
    이분탐색
    https://www.acmicpc.net/problem/2805
    나무자르기
 */
class Solve17 {
    // 이분탐색 예약
    fun main() {
        val (N, M) = readln().split(" ").map { it.toInt() }
        val trees = readln().split(" ").map { it.toInt() }

        var max = trees.max()
        var min = 0

        while(min < max) {
            val mid = (max + min) / 2
            var sum: Long = 0

            for(i in trees.indices) {
                if(trees[i] - mid > 0) {
                    sum += (trees[i] - mid)
                }
            }

            if(sum < M) {
                max = mid
            }
            else {
                min = mid + 1
            }
        }
        println(min-1)
    }
}