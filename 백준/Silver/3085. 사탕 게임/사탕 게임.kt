import java.io.BufferedReader
import java.io.InputStreamReader

var width = 0
var height = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // store input data
    val input = (0 until readLine().toInt()).map {
        readLine().toCharArray()
    }.toTypedArray()
    // solve problem
    solve(input)
}

fun solve(input: Array<CharArray>) {
    // create candy map instance
    var maxScore = 0
    val candyMap = CandyMap(input)
    width = candyMap.map[0].size
    height = candyMap.map.size

    // println("map width: $width height:$height")

    // loop vertical and horizontal and find max score
    candyMap.map.forEachIndexed { y, row ->
        row.forEachIndexed { x, col ->
            // swap point to top and bottom each and get max score
            maxScore = maxOf(maxScore,
                candyMap.getMaxScore(candyMap.swapCandy(Point(x, y), Point(x, y + 1))))
            maxScore = maxOf(maxScore,
                candyMap.getMaxScore(candyMap.swapCandy(Point(x, y), Point(x + 1, y))))
        }
    }

    // print answer
    println(maxScore)
}

class CandyMap(
    val map: Array<CharArray>
) {
    // return copied swapped candy map
    fun swapCandy(point1: Point, point2: Point): Array<CharArray> {
        val copiedMap = map.deepCopy()

        if (point1.isInMap() && point2.isInMap()) {
            // println("$point1 $point2")
            val temp = copiedMap[point1.y][point1.x]
            copiedMap[point1.y][point1.x] = copiedMap[point2.y][point2.x]
            copiedMap[point2.y][point2.x] = temp
        }
        // printMap(copiedMap)
        return copiedMap
    }

    // return max score of input candy map
    fun getMaxScore(candyMap: Array<CharArray>): Int {
        var maxScore = 1
        var point = 1
        // search vertical
        repeat(width) { x ->
            point = 1
            repeat(height) { y ->
                if (Point(x, y+1).isInMap()) {
                    // println("search: x=$x y=$y, x=$x y=${y+1}: ${candyMap[y][x]} ${candyMap[y+1][x]}")
                    if (candyMap[y][x] == candyMap[y + 1][x]) {
                        point++
                        maxScore = maxOf(point, maxScore)
                    } else {
                        maxScore = maxOf(point, maxScore)
                        point = 1
                    }
                }
            }
        }

        // search horizontal
        repeat(height) { y ->
            point = 1
            repeat(width) { x ->
                if (Point(x + 1, y).isInMap()) {
                    // print("search: x=$x y=$y, x=${x+1} y=$y: ${candyMap[y][x]} ${candyMap[y][x + 1]} ")
                    if (candyMap[y][x] == candyMap[y][x+1]) {
                        // println(point)
                        point++
                        maxScore = maxOf(point, maxScore)
                    } else {
                        // println(point)
                        maxScore = maxOf(point, maxScore)
                        point = 1
                    }
                }
            }
        }

        return maxScore
    }
}

fun Array<CharArray>.deepCopy(): Array<CharArray> {
    val copiedMap = Array(height) { CharArray(width) }
    this.mapIndexed { rowIndex, row ->
        row.mapIndexed() { colIndex, col ->
            copiedMap[rowIndex][colIndex] = col
        }
    }.toTypedArray()
    return copiedMap
}

fun printMap(map: Array<CharArray>) {
    val sb = StringBuilder()
    map.forEach { row ->
        row.forEach {
            sb.append(it)
        }
        sb.appendLine()
    }
    println(sb)
}

data class Point(val x: Int, val y: Int) {
    fun isInMap() =
        (x in 0 until width) && (y in 0 until height)
}