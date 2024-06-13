import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var result = 0
    (1..readLine().toInt()).map {
        val (numA, op, numB) = readLine().split(" ")
        result += when(op) {
            "+" -> numA.toInt() + numB.toInt()
            "-" -> numA.toInt() - numB.toInt()
            "/" -> numA.toInt() / numB.toInt()
            "*" -> numA.toInt() * numB.toInt()
            else -> 0
        }
    }
    print(result)
}