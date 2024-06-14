import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val result = StringBuilder()
	val number = readLine().toInt()
	
	for(i in 1..number * number) {
		result.append("$i")
		if(i % number == 0) {
			result.append("\n")
		}
		else {
			result.append(" ")
		}
	}
	
	print(result)
}