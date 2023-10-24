package remind

class RSolve1 {
    companion object {
        fun main() {
            println(solution(8, 4, intArrayOf(2, 3, 6)))
        }

        fun solution(n: Int, m: Int, section: IntArray): Int {
            var answer = 0
            var idx = 0

            for (i in section) {
                if (i >= idx) {
                    idx += m
                    answer++
                }
            }

            return answer
        }
    }

}