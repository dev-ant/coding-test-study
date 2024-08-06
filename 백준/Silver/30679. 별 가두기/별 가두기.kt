import java.io.BufferedReader
import java.io.InputStreamReader

/*
1. store input data
   -> Map = Array<Array<Square>>, Square = Step:Int, Visited:Boolean
2. simulate start
3. if star arrive same place twice exit
4. if star run outside of map exit
 */

data class Square(var step:Int, var visited:Int = 4) {
    fun init(step: Int) {
        this.step = step
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // store input data
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val map = Array(N) { Array(M) { Square(0) } }
    map.forEach { row ->
        val line = readLine().split(" ").map { it.toInt() }
        row.forEachIndexed { index, square ->
            square.init(line[index])
        }
    }

    // simulate start
    val answer = arrayListOf<Int>()
    for(sy in 0 until N) {
        if(simulate(map, sy)) {
            answer.add(sy)
        }
    }
    println(answer.size)
    for (sy in answer) {
        print("${sy + 1} ")
    }
}

fun printMap(map: Array<Array<Square>>) {
    map.forEach { it ->
        it.forEach { print("${it.step} ") }
        println()
    }
}

fun simulate(map: Array<Array<Square>>, sy:Int): Boolean {
    // set dx dy, move right -> down -> left -> up
    val direction = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    var directionNum = 0
    // sx = star x, sy = star y
    var sx = 0
    var sy = sy
    map.forEach { it ->
        it.forEach { square ->
            square.visited = 4
        }
    }
    map[sy][sx].visited = 0

    // simulate until exit
    while(true) {
        // move star
        val mx = direction[directionNum].first * map[sy][sx].step
        val my = direction[directionNum].second * map[sy][sx].step
        sx += mx
        sy += my
        // println("move: x = $sx y = $sy")
        // if star run outside of map exit
        if (isExitMap(map, sx, sy)) {
            // println("isExited: x = $sx y = $sy")
            return false
        }
        // if star arrive same place twice exit
        else if (map[sy][sx].visited == directionNum) {
            // println("isVisited: x = $sx y = $sy")
            return true
        }
        map[sy][sx].visited = directionNum
        directionNum = (directionNum + 1) % 4

    }
}

fun isExitMap(map: Array<Array<Square>>, sx:Int, sy:Int): Boolean {
    return sx >= map[0].size || sx < 0 || sy >= map.size || sy < 0
}