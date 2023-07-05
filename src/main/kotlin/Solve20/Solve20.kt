package Solve20

/*
    https://www.acmicpc.net/problem/2002
 */
class Solve20 {
    fun main() {
        var answer = 0
        val N = readln().toInt()
        val inCar = mutableListOf<String>()
        val outCar = IntArray(N){0}

        for(i in 0 until N) {
            inCar.add(readln())
        }

        for(i in 0 until N) {
            val car = readln()
            outCar[i] = inCar.indexOf(car)
        }

        for(i in 0 until outCar.size-1) {
            for(j in i+1 until outCar.size) {
                if(outCar[i] > outCar[j]) {
                    answer++
                    break
                }
            }
        }
        println(answer)
    }

}