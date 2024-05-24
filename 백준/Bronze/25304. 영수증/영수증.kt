import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val X = nextInt()
    val N = nextInt()
    var sum:Int = 0
    for(i in 1..N) {
        val a = nextInt()
        val b = nextInt()
        sum += a * b
    }
    print(when {
        sum == X -> "Yes"
        else -> "No"
    })
}