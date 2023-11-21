package Test

class RPSolve4 {
    fun solution(total_sp: Int, skills: Array<IntArray>): IntArray {
        val childCount = skills.size + 1
        val parentCount = skills.size + 1
        val childPoints = IntArray(childCount)
        val parentPoints = IntArray(parentCount)

        // 계층 구조를 기반으로 상위 스킬에 스킬 포인트를 할당
        for (skill in skills) {
            val child = skill[0]
            val parent = skill[1]
            childPoints[child - 1]++
            parentPoints[parent - 1] += childPoints[child - 1]
        }

        val result = IntArray(childCount)

        // 최상위 스킬의 스킬 포인트를 설정
        result[0] = total_sp

        // 각 스킬의 스킬 포인트를 계산
        fun calculateSkillPoints(skill: Int) {
            for (i in 0 until parentCount) {
                if (parentPoints[i] == skill) {
                    calculateSkillPoints(i + 1)
                    result[skill - 1] += result[i]
                }
            }
        }

        // 최하위 스킬부터 시작하여 스킬 포인트를 계산
        for (i in 0 until childCount) {
            if (childPoints[i] == 0) {
                calculateSkillPoints(i + 1)
            }
        }

        return result
    }

    fun main() {
        val total_sp = 121
        val skills =
            arrayOf(intArrayOf(7, 21), intArrayOf(1, 31), intArrayOf(3, 61), intArrayOf(3, 4), intArrayOf(3, 5))
        val result = solution(total_sp, skills)
        println("Required skill points for each skill: ${result.joinToString(", ")}")
    }
}

