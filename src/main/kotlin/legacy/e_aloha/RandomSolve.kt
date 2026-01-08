package legacy.e_aloha

fun main() {
    // 문제 번호 입력
    println("문제 번호를 입력하세요 (공백으로 구분):")
    val problemNumbers = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: emptyList()

    if (problemNumbers.isEmpty()) {
        println("유효한 문제 번호를 입력하세요.")
        return
    }

    val teamMembers = listOf("모준서", "이두호", "박지은", "오하은")

    val shuffledProblems = problemNumbers.shuffled()


    val assignments = mutableMapOf<String, MutableList<Int>>()
    teamMembers.forEach { member ->
        assignments[member] = mutableListOf()
    }

    for ((index, problem) in shuffledProblems.withIndex()) {
        val member = teamMembers[index % teamMembers.size]
        assignments[member]?.add(problem)
    }

    assignments.forEach { (member, problems) ->
        println("$member: ${problems.sorted().joinToString(", ")}")
    }
}
