fun main() {
    val AB = readLine()!!.split(" ").map { it.toInt() }

    println(when {
        AB[0] > AB[1] -> ">"
        AB[0] < AB[1] -> "<"
        else -> "=="
    })
}