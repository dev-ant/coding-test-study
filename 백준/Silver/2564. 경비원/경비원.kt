import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs

/*
1. store input data
 * location = data class (x:Int, y:Int)
 * guard = location, shops = List<Location>
2. measure distance between guard and shop
3. print output
 */

data class Location(val x: Int, val y: Int) {
    companion object {
        fun create(info: List<Int>): Location {
            val side = info[0]
            val distance = info[1]
            return when (side) {
                1 -> Location(distance, 0)
                2 -> Location(distance, height)
                3 -> Location(0, distance)
                else -> Location(width, distance)
            }
        }
    }
}

var width = 0
var height = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ").map { it.toInt() }
    width = input[0]
    height = input[1]
    // S = number of shops,
    val S = readLine().toInt()
    val shops = Array<Location>(S) { Location(0, 0) }
    shops.forEachIndexed { index, _ ->
        // side(1 = north, 2 = south, 3 = west, 4 = east)
        shops[index] = Location.create(readLine().split(" ").map { it.toInt() })
    }
    val guard = Location.create(readLine().split(" ").map { it.toInt() })

    // measure distance between guard and shop
    var answer = 0
    for (shop in shops) {
        answer += getDistance(guard, shop)
    }

    print(answer)
}

private fun getDistance(guard: Location, shop: Location): Int {
    var distance = kotlin.math.abs(guard.x - shop.x) + kotlin.math.abs(guard.y - shop.y)
    distance = exceptOpposite(guard, shop, distance)
    // println(distance)
    return minOf(distance, (width * 2 + height * 2) - distance)
}

private fun exceptOpposite(guard: Location, shop: Location, distance: Int): Int {
    return if (kotlin.math.abs(guard.x - shop.x) == width) {
        maxOf(guard.y, shop.y) * 2 + width * 2 - distance
    } else if (kotlin.math.abs(guard.y - shop.y) == height) {
        maxOf(guard.x, shop.x) * 2 + height * 2 - distance
    } else {
        distance
    }
}