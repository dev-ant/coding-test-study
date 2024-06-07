import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    var (left, top) = readLine().split(" ").map { it.toInt() }
    var (right, bottom) = Pair(left, top)


    for (i in 1 until N) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        left = minOf(left, x)
        right = maxOf(right, x)
        bottom = minOf(bottom, y)
        top = maxOf(top, y)
    }

    print("${(right - left) * (top - bottom)}")
}