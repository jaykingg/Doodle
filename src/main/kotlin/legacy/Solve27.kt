package legacy

class Solve27 {
    fun main() {
        println(solution(4))
        println(solution(3))
    }

    var result = 0
    fun solution(n: Int): Long {
        return if (n == 1) 1
        else {
            val arr: LongArray = LongArray(2001)
            arr[1] = 1
            arr[2] = 2
            for (i in 3 until 2001 - 2) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567
            }
            arr[n]
        }


//        goStep(n,0)
//        return (result.toLong()%1234567)
    }

//    private fun goStep(n: Int, count: Int) {
//        for(i in 1 .. 2) {
//            val nextCount = count + i
//            if(nextCount == n) {
//                result++
//                return
//            }
//            else if(nextCount > n) {
//                return
//            }
//            else {
//                goStep(n, nextCount)
//            }
//        }
//
//    }

}
