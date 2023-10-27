import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Double.parseDouble
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    print(parseDouble(st.nextToken())/ parseDouble(st.nextToken()))
}