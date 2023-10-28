import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Double.parseDouble
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var a = Integer.parseInt(st.nextToken())
    var b = Integer.parseInt(st.nextToken())

    println("${a+b}")
    println("${a-b}")
    println("${a*b}")
    println("${a/b}")
    println("${a%b}")

    br.close()
}