import java.io.BufferedReader
import java.io.InputStreamReader

fun main (args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val result = StringBuilder()
	(1..readLine().toInt()).mapIndexed { index, _ ->
		val (stockAmount, stockPrice) = readLine().split(" ").map { it.toDouble() }
		Pair(index + 1, (stockAmount * stockPrice * 10).toInt())
	}.sortedBy { -it.second }.forEach { result.append("${it.first} ") }
	
	print(result)
}