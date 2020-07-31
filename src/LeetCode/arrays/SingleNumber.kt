package LeetCode.arrays

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
            val list = mutableListOf<Int>()
        for (num in nums) {
            if (list.contains(num)) {
                list.remove(num)
            }
            else{
                list.add(num)
            }
        }
        return list[0]
    }
}