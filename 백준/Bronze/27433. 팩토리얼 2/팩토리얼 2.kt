import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toLong()
    println(when {
        N >= 1 -> factorial(N)
        else -> 1
    })
}

fun factorial(num: Long): Long {
    var result = num
    if (num > 1) result *= factorial(num - 1)
    return result
}