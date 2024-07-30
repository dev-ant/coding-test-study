import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val answer = StringBuilder()
    while(true) {
        val input = readLine().split(" ").map { it.toInt() }
        if(input[0] == 0) {
            break
        }
        else {
            answer.appendLine(isTriangle(input))
        }
    }
    print(answer)
}

fun isTriangle(sides: List<Int>): String {
    val sortedSides = sides.sorted()
    return if(sortedSides[2] >= sortedSides[1] + sortedSides[0]) {
        "Invalid"
    }
    else {
        if(sortedSides[0] == sortedSides[1] && sortedSides[1] == sortedSides[2]) {
            "Equilateral"
        } else if(sortedSides[0] == sortedSides[1] || sortedSides[1] == sortedSides[2]) {
            "Isosceles"
        } else {
            "Scalene"
        }
    }
}