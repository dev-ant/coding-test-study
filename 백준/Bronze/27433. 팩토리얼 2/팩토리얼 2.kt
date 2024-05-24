import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toLong()
    println(factorial(N))
}

fun factorial(num: Long): Long {
    return if(num >= 1) {
        num * factorial(num - 1)
    }
    else {
        1
    }
}