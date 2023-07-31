import java.lang.Integer.max

class Solve31 {
    fun main() {
        println(solution(intArrayOf(130, 191, 200, 10)))
        println(improvedSolution(intArrayOf(130, 191, 200, 10)))

    }

    /*
        기존 함수 O(n-1^2)
        개선 후
        내림차순으로 정렬 O(n), 내림차순으로 하게되면 조건에 맞는 첫 값이 최대값이다.
        Worst Case (n-1^2)
        Base Case (n+1) - 개선 전에는 o(n+a) 이며 a 의 번위는 Range 가 길어질 수록 길어짐.
     */
    fun solution(A: IntArray): Int {
        // 시간 제한이 없으므로 모든 케이스를 진행하며 check 하는 것으로 진행.
        // 어떤 수의 첫 번째 자리, 마지막 자리를 구하는 방법은 String 보다 Int 로 집행하는 것이 메모리적으로 효율적이라 판단, 함수 생성.
        var result = -1

        // A 배열의 첫 번째을 기준으로,
        for (baseIndex in 0 until A.size - 1) {
            val baseFirstDigit = firstDigit(A[baseIndex])
            val baseLastDigit = lastDigit(A[baseIndex])

            // baseIndex+1 부터 첫 번째자리, 두 번째 자리를 비교.
            for (diffIndex in baseIndex + 1 until A.size) {
                val diffFirstDigit = firstDigit(A[diffIndex])
                val diffLastDigit = lastDigit(A[diffIndex])

                // 각 자리가 같을 경우, 기존에 저장된 값과 비교하여 최대 값 저장.
                if (baseFirstDigit == diffFirstDigit && baseLastDigit == diffLastDigit) {
                    result = max(result, (A[baseIndex] + A[diffIndex]))
                }
            }
        }

        // 전체 체크 후 최대 값으로 저장된 변수 리턴
        return result
    }

    // 첫 번째 자리를 구하는 함수.
    private fun firstDigit(n: Int): Int {
        var digit = n
        while (digit >= 10) {
            digit /= 10
        }
        return digit
    }

    // 마지막 자리를 구하는 함수.
    private fun lastDigit(n: Int): Int {
        return n % 10
    }

    fun improvedSolution(A: IntArray): Int {
        // 정렬 O(n)
        val sortedArray = A.sortedArrayDescending()

        // 체크 시작
        // Worst Case (n-1^2)
        // Base Case (n+1) - 개선 전에는 o(n+a) 이며 a 의 번위는 Range 가 길어질 수록 길어짐.
        for (baseIndex in 0 until sortedArray.size - 1) {
            val baseFirstDigit = firstDigit(sortedArray[baseIndex])
            val baseLastDigit = lastDigit(sortedArray[baseIndex])

            for (diffIndex in baseIndex + 1 until sortedArray.size) {
                val diffFirstDigit = firstDigit(sortedArray[diffIndex])
                val diffLastDigit = lastDigit(sortedArray[diffIndex])

                if (baseFirstDigit == diffFirstDigit && baseLastDigit == diffLastDigit) {
                    return sortedArray[baseIndex] + sortedArray[diffIndex]
                }
            }
        }
        return -1
    }
}
