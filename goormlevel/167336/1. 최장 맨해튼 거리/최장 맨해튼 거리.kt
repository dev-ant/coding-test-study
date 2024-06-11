import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arrayList = ArrayList<Int>()
    readLine().split(" ").map { it.toInt() }.sorted().forEach {
        arrayList.add(it)
    }
    print("${(abs(arrayList[3] - arrayList[0])) + (abs(arrayList[2] - arrayList[1]))}")
}