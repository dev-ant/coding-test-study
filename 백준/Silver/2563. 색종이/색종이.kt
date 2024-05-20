import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val graph = Array(100) { BooleanArray(100) }
    var total = 0
    
    repeat(nextInt()) {
        val x = nextInt()
        val y = nextInt()
        
        for (i in x until x + 10) {
            for (j in y until y + 10) {
                if (graph[i][j]) continue
                graph[i][j] = true
                total++
            }
        }
    }
    
    print(total)
}