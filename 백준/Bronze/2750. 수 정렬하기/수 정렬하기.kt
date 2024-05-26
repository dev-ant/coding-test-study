import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = ArrayList<Int>()
    for(i in 0 until N) {
        arr.add(readLine().toInt())
    }
    val arrSorted = arr.sorted()
    for(i in 0 until N) {
        println(arrSorted[i])
    }
}