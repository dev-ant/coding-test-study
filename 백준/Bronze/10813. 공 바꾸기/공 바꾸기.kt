import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val arr = IntArray(N + 1)

    for(i in 1 .. N) {
        arr[i] = i
    }

    for(i in 0 until M) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    for(i in 1 .. N) {
        print("${arr[i]} ")
    }
}