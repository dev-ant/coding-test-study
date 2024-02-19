import java.util.StringTokenizer

fun main() {
    readln()
    var count: Int = 0
    val st = StringTokenizer(readln())
    val V = readln().toInt()
    while (st.hasMoreTokens()) {
        if (st.nextToken().toInt().equals(V)) {
            count++
        }
    }

    println(count)
}
