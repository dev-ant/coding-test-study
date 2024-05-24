import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    var sum:Int = 0
    for(i in 1..N) {
        sum += i
    }
    print(sum)
}