class Solve30 {
    fun main() {
        println(solution(intArrayOf(1, 3, 6, 4, 1, 2)))
    }

    fun solution(A: IntArray): Int {
        val sortedArr = A.distinct().filter { it > 0 }.sorted()
        if (sortedArr.isEmpty()) return 1
        else {
            sortedArr.forEachIndexed { index, it ->
                if (index + 1 != it) return index
                if (index + 1 == sortedArr.size) return sortedArr.size + 1
            }
        }

        return 1

    }

}
