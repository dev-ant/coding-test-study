import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var yof = Integer.parseInt(br.readLine())
    var ady = yof - 543
    print(ady)
}