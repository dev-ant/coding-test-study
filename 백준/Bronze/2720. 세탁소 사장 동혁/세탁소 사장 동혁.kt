import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val unit = intArrayOf(25, 10, 5, 1)
    val sb = StringBuilder()
    val array = IntArray(N)

    for (i in 0 until N) {
        array[i] = readLine().toInt()
    }

    for (i in 0 until N) {
        for(j in 0 until 4) {
            sb.append("${array[i] / unit[j]}").append(" ")
            array[i] %= unit[j]
        }
        sb.append("\n")
    }

    print(sb)
}