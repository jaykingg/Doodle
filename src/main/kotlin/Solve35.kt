import java.util.*

class Solve35 {
    /*
        https://www.acmicpc.net/problem/9935

        최대 문자열이 100만개 이기 때문에 replaceAll은 메모리 초과발생
        따라서 stack 으로 넣음과 동시에 체크하는 방식으로 해결
     */
    fun main() {
        val word = readLine()!!.toString()
        val c4 = readLine()!!.toString()

        val stack: Stack<String> = Stack<String>()
        for (i in word.indices) {
            stack.add(word[i].toString())

            var flag = true
            if (stack.size >= c4.length) {
                for (j in c4.indices) {
                    if (stack[stack.size - c4.length + j] != c4[j].toString()) {
                        flag = false
                        break
                    }
                }

                if (flag) {
                    for (j in c4.indices) {
                        stack.pop()
                    }
                }
            }
        }

        if (stack.size == 0) {
            println("FRULA")
        } else {
            println(stack.joinToString(""))
        }
    }
}