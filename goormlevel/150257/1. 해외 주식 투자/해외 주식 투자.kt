import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
	val bw = BufferedWriter(OutputStreamWriter(System.out))
	
	(1..readLine()!!.toInt())
		.mapIndexed { index, _ ->
			val (v, w) = readLine()!!.split(" ")
			val price = (v.toDouble() * w.toDouble() * 10).toInt()
			Pair(price, index + 1)
		}
	  .sortedBy{ -it.first }
		.forEach { bw.write("${it.second} ") }
		
	bw.flush()
	bw.close()
}