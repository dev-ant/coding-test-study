import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val A = readLine().toInt()
    val B = readLine().toInt()
    print(A * B)
}