package a_coding_test.before

class KySolve3 {
    fun main() {
        val n = 20

        val m = 7

        var pizzas = 0
        var coupons = n

        while (coupons >= m) {
            val slicesFromCoupons = coupons / m
            pizzas += slicesFromCoupons
            coupons %= m
            coupons += slicesFromCoupons
        }

        println(pizzas + n)
    }
}
