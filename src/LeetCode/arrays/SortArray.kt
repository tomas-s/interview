package LeetCode.arrays


fun main() {
    SortArray().run { println(sortArrayByParity(intArrayOf(3, 1, 2, 4))) }
}

//even - pardny
//odd - neparny
class SortArray {
    fun sortArrayByParity(array: IntArray): IntArray {
        for (i in 0..array.lastIndex) {
            if (isOdd(array[i])) {
                val oddIndex = i
                val nextEvenIndex = findNextEven(array, oddIndex)
                if (nextEvenIndex != null) {
                    switchNumbers(oddIndex, nextEvenIndex, array)
                }
            }
        }
        return array
    }


    fun listTest(array: IntArray) {
        val list = array.toMutableList()
        val temp = list.get(2)
        list.removeAt(2)
        list.add(1,temp)
        println(list)

    }

    private fun switchNumbers(oddIndex: Int, nextEvenIndex: Int, array: IntArray) {
        val temp = array[nextEvenIndex]
        for (i in nextEvenIndex downTo oddIndex) {
            if (i != 0) {
                array[i] = array[i - 1]
            }
        }
        array[oddIndex] = temp
    }

    private fun findNextEven(array: IntArray, startintIndex: Int): Int? {
        for (i in startintIndex + 1..array.lastIndex) {
            if (isEven(array[i])) {
                return i
            }
        }
        return null
    }

    private fun isEven(i: Int): Boolean {
        return i % 2 == 0
    }

    private fun isOdd(i: Int): Boolean {
        return !isEven(i)
    }

}