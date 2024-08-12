import java.io.BufferedReader
import java.io.InputStreamReader

/*
1. Store input data
2. Simulate start
    2-1. Truck move
    2-2. Get sum of truck weight in bridge
    2-3. If bridge is fine enter next truck
    2-4. If bridge is not fine do not enter
3. Print output
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // Store input data
    // n = number of trucks, w = width of bridge, L = maximum load on the bridge
    val (n, w, L) = readLine().split(" ").map { it.toInt() }
    val aList = readLine().split(" ").map { it.toInt() }
    val trucks = arrayListOf<Int>()
    aList.forEach { trucks.add(it) }
    simulate(n, w, L, trucks)
}

private fun simulate(n: Int, w: Int, L: Int, trucks: ArrayList<Int>) {
    var time = 0
    val bridge = Array<Int>(w) { 0 }
    while (true) {
        // Drive trucks on bridge
        driveBridgeTruck(bridge)
        time++
        // If bridge is fine to enter next truck
        if (isBridgeFine(L, bridge, trucks) && trucks.isNotEmpty()) {
            enterTruck(trucks, bridge)
        }
        // If all truck passed, break
        if (bridge.sum() == 0 && trucks.isEmpty()) {
            break
        }
    }
    println(time)
}

private fun isBridgeFine(L: Int, bridge: Array<Int>, trucks: ArrayList<Int>): Boolean {
    return ((trucks.firstOrNull() ?: 0) + bridge.sum()) <= L
}

private fun driveBridgeTruck(bridge: Array<Int>) {
    for (i in 0 until bridge.lastIndex) {
        bridge[i] = bridge[i + 1]
    }
    bridge[bridge.lastIndex] = 0
}

private fun enterTruck(trucks: ArrayList<Int>, bridge: Array<Int>) {
    bridge[bridge.lastIndex] = trucks.removeFirst()
}