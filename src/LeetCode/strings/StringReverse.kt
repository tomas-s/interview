package LeetCode.strings

fun main() {
    println(reverseString(charArrayOf('h', 'e', 'l', 'l', 'o')).toString())
}

fun reverseString(s: CharArray): Unit {
    var toIndex = s.size / 2
    if (isArraySizeEven(s)) {
        toIndex--
    }
    for (i in 0..toIndex) {
        val temp = s[i]
        s[i] = s[s.lastIndex - i]
        s[s.lastIndex - i] = temp
    }
    println(s.toList())
}

fun isArraySizeEven(s: CharArray): Boolean {
    return s.size % 2 == 0
}