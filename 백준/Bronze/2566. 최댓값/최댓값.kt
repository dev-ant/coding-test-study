import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val grid = Array(9) { IntArray(9) }
    var maxNum = 0
    var maxRow = 0
    var maxCol = 0

    for (i in 0..8) {
        for (j in 0..8) {
            grid[i][j] = nextInt()
            
            if (grid[i][j] > maxNum) {
                maxNum = grid[i][j]
                maxRow = i
                maxCol = j
            }
        }
    }

    print("$maxNum\n${maxRow + 1} ${maxCol + 1}")
}