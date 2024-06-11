import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

val accountBook = ArrayList<Int>()
var sum = 0L
var saving:Boolean = true

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    for(i in 0 until N) {
      val input = readLine().split(" ")
      val amount = if (input[0] == "in") input[1].toInt() else -input[1].toInt()
			sum += amount
			if(sum < 0) {
				saving = false
			}
    }
		
		print(when(saving) {
			true -> "success"
			else -> "fail"
		})
}