import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sum:Int = 0
    val list = mutableListOf<Int>()

    repeat(5) {
        val temp = readLine().toInt()
        sum += temp
        list.add(temp)
    }

    println(sum / 5)
    println(list.sorted()[2])
}