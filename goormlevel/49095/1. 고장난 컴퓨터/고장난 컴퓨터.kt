import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (N, c) = readLine().split(" ").map { it.toInt() }
	val tList = readLine().split(" ").map { it.toInt() }
	var remains = 1
	for (i in 1 until N) {
		remains = if(tList[i] - tList[i - 1] > c) 1 else remains + 1
	}
	print(remains)
}