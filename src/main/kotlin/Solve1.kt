class Solve1 {
    val n = 8
    val m = 4
    private val section: IntArray = intArrayOf(2, 3, 6)

    fun main() {
        println(solution(n,m,section))
    }

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/161989
     */
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var idx: Int = 0

        for (i in section) {
            if (i >= idx) {
                idx = i + m
                answer++
            }
        }

        return answer
    }
}