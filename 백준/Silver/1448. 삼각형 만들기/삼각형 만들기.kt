import java.util.Arrays

fun main() {
    val n = readln().toInt()
    val length = List(n) { readLine()!!.toInt() }

    val sortedLength = length.sortedDescending()
    println(getMaxTriangle(n, sortedLength))
}

private fun getMaxTriangle(n: Int, sortedLength: List<Int>): Int {
    for (i in 0 until n - 2) {
        if (sortedLength[i] < sortedLength[i + 1] + sortedLength[i + 2]) {
            return sortedLength[i] + sortedLength[i + 1] + sortedLength[i + 2]
        }
    }
    return -1
}
