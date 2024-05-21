import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val list = mutableListOf<Int>()

    repeat(N) {
        list.add(readLine().toInt())
    }

    list.sorted().forEach {
        println(it)
    }
}