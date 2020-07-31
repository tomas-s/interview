package LeetCode.arrays

fun main() {
    MoveZeroes().run { moveZeroes(intArrayOf(0, 1, 0, 3, 12)) }
}

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        for (i in 0..nums.lastIndex) {
            if (nums[i] == 0) {
                val indexOfNonZero = findNextNonZero(i, nums)
                if (indexOfNonZero != null) {
                    switchNumbers(i, indexOfNonZero, nums)
                }
            }
        }


        println(nums.toList())
    }

    private fun switchNumbers(i: Int, indexOfNonZero: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[indexOfNonZero]
        nums[indexOfNonZero] = temp
    }

    private fun findNextNonZero(actualIndex: Int, nums: IntArray): Int? {
        for (i in actualIndex..nums.lastIndex) {
            if (nums[i] != 0) return i
        }

        return null
    }
}