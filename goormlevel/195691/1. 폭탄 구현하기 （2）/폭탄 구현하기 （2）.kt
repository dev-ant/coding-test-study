import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    // save input data to variable
    val (sideLength, bombTime) = readLine().split(" ").map { it.toInt() }
    val ground = Array(sideLength) { CharArray(sideLength) }
    val groundBombed = Array(sideLength) { IntArray(sideLength) { 0 } }
    for (i in ground.indices) {
        val row = readLine().split(" ").map { it.single() }
        for (j in ground.indices) {
            ground[i][j] = row[j]
        }
    }
    repeat(bombTime) {
        val (y, x) = readLine().split(" ").map { it.toInt() }
        aimBomb(groundBombed, ground, y - 1, x - 1)
    }
    
    print(groundBombed.flatMap { it.asIterable() }.maxOrNull() ?: -1)
}

private fun aimBomb(groundBombed: Array<IntArray>, ground: Array<CharArray>, y: Int, x: Int) {
    val bombRanges = arrayOf(Pair(0, 0), Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    bombRanges.forEach {
        if (isInGround(y, x, it, ground.size)) {
            launchBomb(groundBombed, ground, y - it.first, x - it.second)
        }
    }
}

private fun isInGround(y: Int, x: Int, bombRange: Pair<Int, Int>, groundRange: Int): Boolean {
    return (y - bombRange.first >= 0) && (y - bombRange.first < groundRange)
            && (x - bombRange.second >= 0) && (x - bombRange.second < groundRange)
}

private fun launchBomb(groundBombed: Array<IntArray>, ground: Array<CharArray>, ty: Int, tx: Int) {
    when (ground[ty][tx]) {
        '@' -> groundBombed[ty][tx] += 2
        '0' -> groundBombed[ty][tx] += 1
        else -> {}
    }
}
