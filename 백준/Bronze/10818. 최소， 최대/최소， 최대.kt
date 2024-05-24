import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val size = readLine().toInt()
    val arr = IntArray(size)

    StringTokenizer(readLine()).run {
        for(i in 0 until size) {
            arr[i] = nextToken().toInt()
        }
    }


    println("${arr.sorted()[0]} ${arr.sorted()[size - 1]}")
}