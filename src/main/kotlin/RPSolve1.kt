class RPSolve1 {
    fun solution(location: Array<IntArray>, s: IntArray, e: IntArray): Int {
        var answer = 0

        val xs = minOf(s[0], e[0])
        val xe = maxOf(s[0], e[0])
        val ys = minOf(s[1], e[1])
        val ye = maxOf(s[1], e[1])

        for (unit in location) {
            val x = unit[0]
            val y = unit[1]
            if (x in xs..xe && y in ys..ye) {
                answer++
            }
        }

        return answer
    }

    fun main() {
        val location = arrayOf(
            intArrayOf(0, 3),
            intArrayOf(1, 1),
            intArrayOf(1, 5),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(4, 0)
        )
        val startingPoint = intArrayOf(1, 4)
        val endingPoint = intArrayOf(4, 1)

        val selectedUnits = solution(location, startingPoint, endingPoint)
        println("Number of selected units: $selectedUnits")
    }


}


