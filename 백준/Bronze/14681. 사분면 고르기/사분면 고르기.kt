import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val x = readLine().toInt()
    val y = readLine().toInt()
    println(when {
        x > 0 && y > 0 -> "1"
        x < 0 && y > 0 -> "2"
        x > 0 && y < 0 -> "4"
        else -> "3"
    })
}