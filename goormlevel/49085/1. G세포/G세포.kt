import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val goalCellSize = readLine().toInt()
	val splitTimes = ArrayList<Int>()
	val result = StringBuilder()
	
	simulateCellSplit(splitTimes, goalCellSize)
	printResult(result, splitTimes)
}

private fun simulateCellSplit(splitTimes: ArrayList<Int>, goalCellSize:Int) {
	var simGoalCellSize = goalCellSize
	while(true) {
		var cellSize = 1
		var splitTime = 0
		while(true) {
			if(cellSize * 2 > simGoalCellSize) {
				simGoalCellSize -= cellSize
				splitTimes.add(splitTime)
				// Log: println("${cellSize} ${splitTime}")
				break
			}
			else {
				cellSize *= 2
				splitTime++
			}
		}
		if(simGoalCellSize == 0) {
			break
		}
	}
}

private fun printResult(result: StringBuilder, splitTimes:ArrayList<Int>) {
	result.append("${splitTimes.size}").append("\n")
	splitTimes.reversed().forEach {
		result.append("$it ")
	}
	print(result)
}