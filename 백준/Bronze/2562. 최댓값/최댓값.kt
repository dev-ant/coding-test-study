import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = IntArray(9)
    val size = 9
    var maxValue = 0
    var maxIndex = 0

    for(i in 0 until size) {
        arr[i] = readLine().toInt()
        if(maxValue < arr[i]) {
            maxValue = arr[i]
            maxIndex = i + 1
        }
    }

    print("$maxValue $maxIndex")
}