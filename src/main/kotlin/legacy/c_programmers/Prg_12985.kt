package legacy.c_programmers

class Prg_12985 {
    /*
        https://school.programmers.co.kr/learn/courses/30/lessons/12985
    */
    fun main() {
        println(solution(8, 4, 7))
    }

    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1

        var A = a.toDouble()
        var B = b.toDouble()
        while (A != B) {
            A = Math.ceil(A / 2)
            B = Math.ceil(B / 2)
            if (A == B) break
            answer++
        }
//        var n = n
//        val queue = LinkedList<Int>()


//        for(i in 1 until n+1) {
//            queue.add(i)
//        }
//
//        answer++
//        while(queue.isNotEmpty()) {
//            for(i in 0 until n/2) {
//                val first = queue.poll()
//                val second = queue.poll()
//                if(first == a && second == b) {
//                    return answer
//                }
//                else {
//                    if(first == a || first == b ) {
//                        queue.add(first)
//                    }
//                    else if(second == a || second == b) {
//                        queue.add(second)
//                    }
//                    else {
//                        queue.add(first)
//                    }
//                }
//            }
//            n /= 2
//            answer++
//        }
//
        return answer
    }

}
