import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	// Input data : N -> testCount, M -> subjectCount
	val (testCount, subjectCount) = readLine().split(" ").map { it.toInt() }
	// subjectScores[][0] = code, subjectScore[][1] = sum
	val subjectScores = Array (subjectCount + 1) { DoubleArray (2) }
	
	// 
	repeat(testCount) { 
		val (subjectCode, testScore) = readLine().split(" ").map { it.toDouble() }
		subjectScores[subjectCode.toInt()][0]++
		subjectScores[subjectCode.toInt()][1] += testScore
	}
	
	// Create list contain average subject score
	val result = subjectScores.
	mapIndexed { index, (count, sum) ->
		index to if (count > 0.0) (sum / count) else 0.0
	}.maxByOrNull { it.second }?.first
	
	
	print(result ?: -1)
}