import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val operationCount = readLine().toInt()
    val result = (1..operationCount)
        .map { readLine().split(" ") }
        .sumOf { (a, op, b) ->
            val x = a.toInt()
            val y = b.toInt()
            when (op) {
                "+" -> x + y
                "-" -> x - y
                "/" -> x / y
                "*" -> x * y
                else -> 0
            }
        }

    println(result)
}