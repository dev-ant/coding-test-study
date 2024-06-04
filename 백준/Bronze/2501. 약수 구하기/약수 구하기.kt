import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val divisor = ArrayList<Int>()
    for(i in 1..sqrt(N.toDouble()).toInt()) {
        if(N % i == 0) {
            divisor.add(i)
        }
    }
    for(i in divisor.size - 1 downTo  0) {
        if(!divisor.contains(N / divisor[i])) {
            divisor.add((N / divisor[i]))
        }
    }


    print(when {
        divisor.size >= K -> divisor[K-1]
        else -> "0"
    })
}

/*
10 1 1
10 2 2
10 3 5
10 4 10
10 5 0
 */
