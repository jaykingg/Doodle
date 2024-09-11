package b_boj

import java.util.LinkedList

/*
    https://www.acmicpc.net/problem/1713
    후보 추천하기
 */


class SolveAC_1713 {
    data class Student(
        val number: Int,
        var count: Int,
        var index: Int
    )


    fun main() {
        val n = readln().toInt()
        val m = readln().toInt()
        val recommend = readln().split(" ").map { it.toInt()}.toList()
        val q = LinkedList<Student>()

        recommend.forEachIndexed { index, student ->
            val value = q.find { it.number == student }
            if(q.size < n) {
                if(value == null) {
                    q.add(Student(student,1,index))
                }
                else {
                    value.count++
                }
            }
            else {
                if(value == null) {
                    q.poll()
                    q.add(Student(student,1,index))
                }
                else {
                    value.count++
                }
            }

            q.sortWith{o1,o2 ->
                if(o1.count == o2.count) {
                    o1.index - o2.index
                }
                else {
                    o1.count - o2.count
                }
            }
        }

        val answer = q.map { it.number }.sortedBy { it }.joinToString(" ")
        println(answer)
    }

}
