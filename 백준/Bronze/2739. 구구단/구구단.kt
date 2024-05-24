import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    for(i in 1..9) {
        println("$N * $i = ${N * i}")
    }
}