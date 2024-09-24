package e_aloha.week3

/**
 * 6th https://www.acmicpc.net/problem/1003
 *
 *
 * 시간이 0.25 이다보니 그냥 DFS 로 하면 폭망이다
 * 손으로 써서 규칙 찾는게 빠를 것 같다
 *
 * 회차 / [0.1]
 *  0  / 1, 0
 *  1 / 0, 1
 *  2 / 1, 1
 *  3 / 1, 2
 *  4 / 2, 3
 *  ...
 *
 *  n = n-2 + n+1 의 위의 값을 지속적으로 더 해주면 된다
 */
fun main() = with(System.`in`.bufferedReader()) {
    val times = readLine().toInt()
 
    repeat(times) {
        val n = readLine().toInt()
        val arr = Array(2) { IntArray(n + 1) { 0 } }


        if (n == 0) {
            println("1 0")
        } else if (n == 1) {
            println("0 1")
        } else {
            // 초기 0,1만 생성
            arr[0][0] = 1
            arr[1][0] = 0
            arr[0][1] = 0
            arr[1][1] = 1

            // n까지 모든 결과 값을 만들어 놓는다
            for (i in 2 until arr[0].size) {
                arr[0][i] = arr[0][i - 1] + arr[0][i - 2]
                arr[1][i] = arr[1][i - 1] + arr[1][i - 2]
            }
            println("${arr[0][n]} ${arr[1][n]}")
        }
    }
}
