import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    var maxScore = 0.0
    var result = 0
    // Pair(test time, test score sum) after for each Pair(test time, test score average)
    val subject = Array (M + 1) { arrayOf<Double> ( 0.0, 0.0 ) }
    (1..N).map {
        val (c, s) = readLine().split(" ").map { it.toDouble() }
        subject[c.toInt()][0]++
        subject[c.toInt()][1] += s
    }

    subject.forEach {
        if (it[0] != 0.0) {
            it[1] /= it[0]
        }
    }

    subject.forEachIndexed { index, it ->
        if(maxScore < it[1]) {
            result = index
            maxScore = it[1]
        }
    }
    
    print(result)
}