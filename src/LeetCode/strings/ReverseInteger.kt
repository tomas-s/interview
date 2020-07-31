package LeetCode.strings

import kotlin.math.pow

fun main() {
    println(ReverseInteger().run { reverse(123) })
}

class ReverseInteger {

    fun reverse(x: Int): Int {
        var retValue: Int = 0
        var isNegative: Boolean = false
        var numberCopy = x
        if (x < 0) {
            isNegative = true
            numberCopy = 0 - x
        }

        val reversedArray = numberCopy.toString().map { it.toString().toInt() }.reversed()
        for (i in reversedArray.lastIndex downTo 0) {
            retValue += reversedArray[i] * 10.0.pow(reversedArray.lastIndex - i).toInt()
        }

        if (isNegative) {
            retValue = 0 - retValue
        }
        return retValue
    }
}