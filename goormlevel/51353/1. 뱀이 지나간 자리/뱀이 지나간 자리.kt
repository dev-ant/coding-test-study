import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (height, width) = readLine().split(" ").map { it.toInt() }
	val snakePaths = Array(height) { CharArray(width) { '.' } }
	val result = StringBuilder()
	
	simulateSnakeMove(snakePaths)
	result.append(snakePaths.joinToString("\n") { it.joinToString("") })
	print(result)
}

private fun simulateSnakeMove(snakePaths: Array<CharArray>) {
	snakePaths.forEachIndexed { direction, row ->
		when(direction % 2 == 0) {
			true -> row.fill('#')
			else -> if(direction % 4 == 3) row[0] = '#' else row[row.size - 1] = '#'
		}		
	}
}