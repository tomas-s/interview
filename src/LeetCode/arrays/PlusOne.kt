package LeetCode.arrays

fun main() {
    val plusOne = PlusOne()
    println(plusOne.plusOne(intArrayOf(1, 2, 3)).toList())
    println(plusOne.plusOne(intArrayOf(9, 9)).toList())
}

class PlusOne {


    fun plusOne(digits: IntArray): IntArray {
        val digitsList = digits.toMutableList()

        val last = digitsList.last()

        for (i in digitsList.lastIndex downTo 0) {
            if (digitsList[i] == 9) {
                if (i == 0) {
                    digitsList[i] = 0
                    digitsList.add(0,1)
                } else {
                    digitsList[i] = 0
                }
            } else {
                digitsList[i] = digitsList[i] + 1
                break
            }
        }



        return digitsList.toIntArray()
    }

}