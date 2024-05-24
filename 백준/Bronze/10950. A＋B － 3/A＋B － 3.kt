import java.lang.StringBuilder
import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val sb = StringBuilder()
    for(i in 1..N) {
        val A = nextInt()
        val B = nextInt()
        sb.append("${A + B}").append("\n")
    }
    println(sb)
}