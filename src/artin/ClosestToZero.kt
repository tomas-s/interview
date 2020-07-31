package artin

import kotlin.math.abs


fun main() {
    ClosestToZero().run { println(getClosestToZero(intArrayOf(50,5,6))) }
}


/**
 * Please implement this method to
 * return the number in the array that is closest to zero.
 * If there are two equally close to zero elements like 2 and -2
 * - consider the positive element to be "closer" to zero.
 */

class ClosestToZero {

    fun getClosestToZero(arr: IntArray): Int {

        var min: Int = Int.MAX_VALUE

        arr.forEach {
            if (abs(min) > abs(it)) {
                min = it
            }
            if (abs(min) == abs(it) && min < 0) {
                min = it
            }
        }
        return min
    }
}