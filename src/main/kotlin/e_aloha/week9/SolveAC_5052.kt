package e_aloha.week9

/**
 * https://www.acmicpc.net/problem/5052
 * 전화번호
 *
 * 한 전화번호가 다른 전화번호의 접두어인 경우 목록은 일관성이 없다.
 * 전화번호들을 사전순 정렬하면,
 * 접두어가 되는 번호는 항상 바로 뒤에 위치함
 * 일관성 업슴 -> NO , 일관성 있음 -> YES
 */
fun main() {
    val cycle = readLine()!!.toInt()

    repeat(cycle) {
        val numbers = readLine()!!.toInt()
        val phoneNumbers = mutableListOf<String>()

        repeat(numbers) {
            phoneNumbers.add(readLine()!!)
        }

        // 정렬
        phoneNumbers.sort()

        var isConsistent = true
        for (i in 0 until phoneNumbers.size - 1) {
            if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
                isConsistent = false
                break
            }
        }
        println(if (isConsistent) "YES" else "NO")
    }
}
