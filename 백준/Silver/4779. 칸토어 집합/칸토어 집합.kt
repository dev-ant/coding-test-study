import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    // Read all lines of input
    val inputLines = mutableListOf<String>()
    while (true) {
        val line = reader.readLine() ?: break
        inputLines.add(line)
    }

    // Process each line of input
    for (line in inputLines) {
        val n = line.toIntOrNull()
        if (n != null) {
            var answer = "-"
            repeat(n) {
                answer = sol(answer)
            }
            println(answer)
        }
    }
}

fun sol(s: String): String {
    return s + " ".repeat(s.length) + s
}