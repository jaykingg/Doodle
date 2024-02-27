class Solve39 {
    /*
    Highest Value Palindrome
    https://www.hackerrank.com/challenges/richie-rich/problem?isFullScreen=true
     */
    fun highestValuePalindrome(s: String, n: Int, k: Int): String {

        return ""
    }

    fun main() {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")
        val n = first_multiple_input[0].toInt()
        val k = first_multiple_input[1].toInt()
        val s = readLine()!!
        val result = highestValuePalindrome(s, n, k)
        println(result)
    }
}
