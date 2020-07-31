package artin

fun main() {
    Reversal().run { println(getReversalsToSort(intArrayOf(12,13,11,14))) }
//    Reversal().run { println(getReversalsToSort(intArrayOf(11, 14, 12, 13))) }
//    Reversal().run { println(getReversalsToSort(intArrayOf(6, 8, 3, 5, 9, 1))) }
}

/**
 * You need to sort an array of integers by repeatedly reversing
 * the order of the first several elements of it.
 *
 * For example, to sort [11,14,12,13], you need to  reverse the order of the first two (2)
 * elements and get [14,11,12,13], then reverse the order of the first four (4) elements
 * and get [13,12,11,14] and then reverse the order of the first three (3) elements.
 *

 * The method should return array of integers corresponding to the required reversals.
 * For the previous example, given an array [11,14,12,13]
 * the method should return a array with integers [2,4,3].
 */
class Reversal {
    fun getReversalsToSort(array: IntArray): List<Int> {
        var list = array.toMutableList()
        val countReversals = mutableListOf<Int>()

        while (list.isNotEmpty()) {
            val maxIndex: Int = findIndexOfMaxElement(list)
            if (maxIndex != 0 && list.lastIndex != maxIndex) {
                countReversals.add(maxIndex + 1)
                list = reverseFirstSeveralsElements(list, maxIndex)
            }

            if (list.lastIndex != maxIndex) {
                countReversals.add(list.size)
                list.reverse()
            }
            list.removeAt(list.lastIndex)
        }
        return countReversals
    }


    private fun reverseFirstSeveralsElements(list: MutableList<Int>, maxIndex: Int): MutableList<Int> {
        val swaps = (maxIndex + 1) / 2
        for (i in 0 until swaps) {
            val temp = list[i]
            list[i] = list[maxIndex - i]
            list[maxIndex - i] = temp
        }
        return list
    }

    private fun findIndexOfMaxElement(list: MutableList<Int>): Int {
        var maxIndex: Int = -1
        var maxElement: Int = Int.MIN_VALUE
        for (i in 0..list.lastIndex) {
            if (maxElement < list[i]) {
                maxElement = list[i]
                maxIndex = i
            }
        }
        return maxIndex
    }


}