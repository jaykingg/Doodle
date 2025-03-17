package e_aloha.week9

/**
 * https://www.acmicpc.net/problem/9663
 * N Queen
 */
fun main() {
    /**
     * 같은 행,열,대각선에 퀸이 있으면 안된다.
     * 1개의 Queen 을 놓고, 검사 후 백트래킹을 해야함
     */
    val n = readLine()!!.toInt()
    println(queen(n))
}

fun queen(n: Int): Int {
    /**
     * N*N 체크 배열을 사용하지 않은 이유 -> 불필요한 메모리 발생
     * n^2 VS 3n
     */
    var count = 0

    // col check
    val columns = BooleanArray(n)

    // ↙ check
    val leftDiagonals = BooleanArray(2 * n - 1)

    // ↘ check
    val rightDiagonals = BooleanArray(2 * n - 1)

    fun backtracking(row: Int) {
        if (row == n) {
            count++
            return
        }

        for (col in 0 until n) {
            val leftDiagonal = row + col
            val rightDiagonal = row - col + (n - 1)

            // queen check
            if (columns[col] || leftDiagonals[leftDiagonal] || rightDiagonals[rightDiagonal]) {
                continue
            }

            // visit check
            columns[col] = true
            leftDiagonals[leftDiagonal] = true
            rightDiagonals[rightDiagonal] = true

            // next row
            backtracking(row + 1)

            // rollback
            columns[col] = false
            leftDiagonals[leftDiagonal] = false
            rightDiagonals[rightDiagonal] = false
        }
    }
    backtracking(0)
    return count
}
