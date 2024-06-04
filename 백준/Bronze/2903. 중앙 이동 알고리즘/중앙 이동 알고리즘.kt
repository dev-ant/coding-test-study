import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    var dotOneSide = 2
    for (i in 1..N) {
        dotOneSide += (dotOneSide - 1)
    }
    print("${dotOneSide * dotOneSide}")
}