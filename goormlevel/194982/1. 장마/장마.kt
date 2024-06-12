import java.io.BufferedReader
import java.io.InputStreamReader

val drainageTargets = mutableSetOf<Int>()
var town = IntArray(0)
val rainTargets = ArrayList<Pair<Int, Int>>()

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    town = readLine().split(" ").map { it.toInt() }.toIntArray()
    for(i in 0 until M) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        rainTargets.add(Pair(s, e))
    }

    rain()
    town.forEach {
        print("$it ")
    }
}

private fun rain() {
    val day = 1
    for(i in 0 until rainTargets.size) {
        for(j in rainTargets[i].first - 1 until rainTargets[i].second) {
            town[j]++
            drainageTargets.add(j)
        }
        drainage(i + 1)
    }
}

private fun drainage(day:Int) {
    if((day) % 3 == 0) {
        drainageTargets.forEach {
            town[it]--
        }
        drainageTargets.clear()
    }
}