import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    print(fibonacci(readLine().toInt()))
}

fun fibonacci(num: Int): Int {
    return when (num) {
        1 -> 1
        0 -> 0
        else -> fibonacci(num - 1) + fibonacci(num - 2)
    }
}