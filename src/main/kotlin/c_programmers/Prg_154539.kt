package c_programmers

import java.util.Stack

class Prg_154539 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/154539
    뒤에 있는 큰 수 찾기
     */
    fun main() {
        val result1 = solution(intArrayOf(2, 3, 3, 5))
        println(result1.joinToString(prefix = "[", postfix = "]"))
        println(result1 contentEquals intArrayOf(3, 5, 5, -1))

        val result2 = solution(intArrayOf(9, 1, 5, 3, 6, 2))
        println(result2.joinToString(prefix = "[", postfix = "]"))
        println(result2 contentEquals intArrayOf(-1, 5, 6, 6, -1, -1))
    }
    /**
     * 2즁 for loop 으로 진행하면 O(n^n+1) -> 시간 초과
     * Stack 은 O(n) + O(n( -> O(2n)
     */
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack: Stack<Int> = Stack()

        stack.add(0)
        for(i in 1 until numbers.size) {
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.add(i)
        }
        return answer
    }
}
