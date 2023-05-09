import java.util.*

class Solve11 {
    fun main() {
        /*
            https://www.acmicpc.net/problem/2504
         */

        val s: Stack<String> = Stack()
        var result: Int = 0
        var temp: Int = 1
        val line = readLine().toString().split("")
        line.forEachIndexed { index, it ->
            when(it) {
                "(" -> {
                    s.add(it)
                    temp *= 2
                }
                "[" -> {
                    s.add(it)
                    temp *= 3
                }
                ")" -> {
                    if(s.isEmpty() || s.peek() != "(") {
                        println(0)
                        return
                    }
                    else if(line[index-1] == "(") {
                        result += temp
                    }
                    temp /= 2
                    s.pop()
                }
                "]" -> {
                    if(s.isEmpty() || s.peek() != "[") {
                        println(0)
                        return
                    }
                    else if(line[index-1] == "[") {
                        result += temp
                    }
                    temp /= 3
                    s.pop()
                }
            }
        }
        if(s.isNotEmpty()) println(0) else println(result)
    }
}