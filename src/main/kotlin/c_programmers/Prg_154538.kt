package c_programmers

class Prg_154538 {
    /**
     * 숫자 변환하기
     * https://school.programmers.co.kr/learn/courses/30/lessons/154538
     */
    fun main() {
        val result1 = solution(10,45,5)
        println(result1)
        println(result1 == 2)
        val result2 = solution(10,40,30)
        println(result2)
        println(result2 == 1)
        val result3 = solution(2,5,4)
        println(result3)
        println(result3 == -1)
    }

    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0
        var diffSet = mutableSetOf<Int>(x)

        while(true) {
            if(y in diffSet) {
                return answer
            }
            else {
                val changedSet: MutableSet<Int> = mutableSetOf()
                diffSet.forEach { i ->
                    if(i+n <= y) changedSet.add(i+n)
                    if(i*2 <= y) changedSet.add(i*2)
                    if(i*3 <= y) changedSet.add(i*3)
                }
                if(changedSet.isEmpty()) return -1
                diffSet = changedSet
                answer++
            }
        }
    }

}
