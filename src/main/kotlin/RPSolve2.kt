class RPSolve2 {
    fun solution(N: Int, trees: Array<IntArray>): Int {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)

        // Create a grid to represent the city
        val grid = Array(N) { IntArray(N) }

        // Mark the grid cells with trees
        for (tree in trees) {
            val x = tree[0]
            val y = tree[1]
            grid[x][y] = 1
        }

        var boundaryTreeCount = 0

        // Check each cell on the boundary for adjacent trees
        for (x in 0 until N) {
            for (y in 0 until N) {
                if (grid[x][y] == 1) {
                    for (dir in 0 until 4) {
                        val nx = x + dx[dir]
                        val ny = y + dy[dir]

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == 0) {
                            boundaryTreeCount++
                        }
                    }
                }
            }
        }

        return boundaryTreeCount
    }

    fun main() {
        val N = 5
        val trees = arrayOf(intArrayOf(4, 3), intArrayOf(3, 1), intArrayOf(2, 2), intArrayOf(1, 4))
        println(solution(N, trees))
//        val trees2 = arrayOf(intArrayOf(4, 3), intArrayOf(3, 1), intArrayOf(2, 2), intArrayOf(1, 4))
//        println(solution(N, trees2))
    }

}