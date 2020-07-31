package LeetCode.arrays

class HappyNumber {
    val set = mutableSetOf<Int>()

    fun isHappy(n: Int): Boolean {
        set.add(n)
        val digits = toDigits(n)

        var sum = 0
        for (it in digits) {
            sum += it * it
        }
        if (sum == 1) return true
        if (set.contains(sum)) return false
        if (isHappy(sum)) return true

        return false
    }

    private fun toDigits(n: Int): MutableList<Int> {
        var number = n
        val digits = mutableListOf<Int>()
        while (number > 0) {
            digits.add(number % 10)
            number /= 10
        }
        return digits
    }
}