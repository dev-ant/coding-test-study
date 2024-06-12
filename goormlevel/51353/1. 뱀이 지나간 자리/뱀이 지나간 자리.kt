import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (height, width) = readLine().split(" ").map { it.toInt() }
    val snakePaths = Array(height) { CharArray(width) {'.'} }
    val result = StringBuilder()

    simulateSnakeMove(width, height, snakePaths)
    result.append(snakePaths.joinToString("\n") { row -> row.joinToString("") })
    print(result)
}

private fun simulateSnakeMove(width: Int, height: Int, snakePaths: Array<CharArray>) {
    var (pointX, pointY) = Pair(0, 0)
    for(col in 0 until height) {
        // move from left to right
        if(col % 4 == 0) {
            for(row in 0 until width) {
                snakePaths[col][row] = '#'
            }
            pointX = width - 1
        }
        // move from right to left
        else if(col % 4 == 2) {
            for(row in (width - 1) downTo 0) {
                snakePaths[col][row] = '#'
            }
            pointX = 0
        }
        // move down on left side or right side
        else {
            snakePaths[++pointY][pointX] = '#'
            // Log point movements: println("UPDOWN: $pointX $pointY" )
            pointY++
        }
    }
}
