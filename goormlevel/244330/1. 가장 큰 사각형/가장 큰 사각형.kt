import java.util.Scanner
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
	val T = readLine().toInt()
	var maxArea = 0
	
	for(i in 0 until T) {
		val (w, h) = readLine().split(" ").map { it.toInt() }
		maxArea = maxOf(maxArea, w * h)
	}
	
	print(maxArea)
}