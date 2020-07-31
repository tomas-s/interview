package artin

fun main() {
    println(countChunks(intArrayOf(5, 4, 0, 0, -1, 0, 2, 0, 0)))
    println(countChunks(intArrayOf(0, 0, 5, 4, 0, 0, -1, 0, 2, 0,5, 0)))
}


/**
 * Please implement this method to return count of chunks in given array.
 *
 *
 * Chunk is defined as continous sequence of one or more numbers divided by one or more zeroes.
 * Array can contain leading and trailing zeroes.
 *
 *
 * Example: array [5, 4, 0, 0, -1, 0, 2, 0, 0] contains 3 chunks
 */
fun countChunks(a: IntArray): Int {
    var isPreviosuZero: Boolean = true
    var chunksCounter = 0

    a.forEach {
        if (it != 0) {
            isPreviosuZero = false
        } else {
            if (!isPreviosuZero) {
                chunksCounter++
            }
            isPreviosuZero = true
        }
    }

    return chunksCounter
}
