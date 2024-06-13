import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val (N, T) = readLine().split(" ")
	inverseR(N, T)
}

private fun inverseR(origin:String, transed:String) {
	for(r in 2..16) {
		if(origin.toLong().toString(r).equals(transed, ignoreCase = true)) {
            print(r)
            break
        }
	}
}