import java.io.BufferedReader
import java.io.InputStreamReader

/*
1. 입력된 값으로 넓이를 구한다.
2. 넓이를 이용해 참외의 수를 구한다.
 */


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val K = readLine().toInt()
    val sides = Array(12) { Pair(0, 0) }
    // store input data
    repeat(6) { it ->
        val side = readLine().split(" ").map { it.toInt() }
        sides[it] = Pair(side[0], side[1])
        sides[it + 6] = Pair(side[0], side[1])
    }
    // calculate dimension of field
    for (i in 0 until 9) {
        if (sides[i].first == sides[i + 2].first && sides[i + 1].first == sides[i + 3].first) {
            var dimension = sides[i + 4].second * sides[i + 5].second - sides[i + 1].second * sides[i + 2].second
            print(dimension * K)
            break
        }
    }
}