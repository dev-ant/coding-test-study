import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var A = nextInt()
    var B = nextInt()
    val C = nextInt()

    B += C

    if (B + C >= 60) {
        A += B / 60
        B %= 60
    }
    if (A >= 24) {
        A -= 24
    }
    println("$A $B")
}