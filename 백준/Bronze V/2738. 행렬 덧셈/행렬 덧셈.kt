import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    var arr = Array(N) { IntArray(M) }

    for (i in 0 until N) {
        st = StringTokenizer(readLine())
        for (j in 0 until M) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 0 until N) {
        st = StringTokenizer(readLine())
        for (j in 0 until M) {
            arr[i][j] += st.nextToken().toInt()
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            sb.append(arr[i][j]).append(" ")
        }
        sb.append("\n")
    }

    println(sb)
}
