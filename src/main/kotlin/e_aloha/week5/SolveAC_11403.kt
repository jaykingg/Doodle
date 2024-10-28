package e_aloha.week5

/**
 * https://www.acmicpc.net/problem/11403
 * 경로 찾기
 *
 *
 * 0 -> 3
 * 1 -> 6
 * 3 -> 4
 * 3 -> 5
 * 4 -> 0
 * 5 -> 6
 * 6 -> 2
 *
 * 0 -> 3-> 4 -> 0
 * 0 -> 3-> 5 -> 6 -> 2
 * ...
 * 모든 정점 쌍 (i, j)에 대해 중간에 경유할 수 있는 정점 k를 고려하여 경로가 있는지를 판별
 *
 * 플로이드-워셜 알고리즘
 * 모든 정점 쌍 간의 최단 경로를 구하는 알고리즘
 * (i -> k -> j)가 기존 (i -> j) 경로보다 짧은지 확인, 모든 i,j 에 대해서 확인
 */
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    // 경유 정점
    for (k in 0 until n) {
        // 정점 i,j
        for (i in 0 until n) {
            for (j in 0 until n) {
                // 0 , 3  / 3, 4 --> 0,4 = 1
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1
                }
            }
        }
    }

    val result = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            result.append(graph[i][j]).append(" ")
        }
        result.append("\n")
    }
    print(result)
}

