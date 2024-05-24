import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = ArrayList<Int>()

    for(i in 1..10) {
        val a = readLine().toInt()
        if((a % 42) !in arr) {
            arr.add(a % 42)
        }
    }

    print(arr.size)
}