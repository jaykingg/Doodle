class Solve32 {
    fun main() {
        println(solution("bytdag", intArrayOf(4, 3, 0, 1, 2, 5)))
    }

    fun solution(S: String, A: IntArray): String {
        // 케이스와 지문 상 첫글자는 String 의 처음과 같음.(고정.)
        // String 의 첫 글자와 Mapping 되는 index 를 시작으로 갱신시켜주며 n-1 만큼 진행.

        // String 연산이 많은만큼 메모리적 효율을 고려하여 StringBuffer 를 사용.
        val stringBuffer = StringBuffer()
        val inputArray: CharArray = S.toCharArray()
        var index: Int = A[0]

        stringBuffer.append(inputArray[0])

        repeat(inputArray.size - 1) {
            if (index == 0) return@repeat
            stringBuffer.append(inputArray[index])
            index = A[index]
        }

        // StringBuffer 에 저장된 값 리턴
        return stringBuffer.toString()
    }

}
