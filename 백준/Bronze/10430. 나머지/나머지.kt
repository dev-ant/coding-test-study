import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    var A = Integer.parseInt(st.nextToken())
    var B = Integer.parseInt(st.nextToken())
    var C = Integer.parseInt(st.nextToken())

    println("${(A+B)%C}")
    println("${((A%C)+(B%C))%C}")
    println("${(A*B)%C}")
    println("${((A%C)*(B%C))%C}")
    br.close()
}