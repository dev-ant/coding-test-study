import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    // store input data
    val N = readLine().toInt()
    val inputs = (1..N).map { readLine() }
    // create stack and execute
    val stack = Stack()
    stack.execute(inputs)
}

class Stack() {
    private val elements = ArrayList<Int>()
    private val log = StringBuilder()

    fun execute(commands: List<String>) {
        // execute commands
        commands.forEach { command ->
            when {
                command.contains("push") -> push(command.split(" ")[1].toInt())
                command.equals("pop", ignoreCase = true) -> pop()
                command.equals("size", ignoreCase = true) -> size()
                command.equals("empty", ignoreCase = true) -> empty()
                command.equals("top", ignoreCase = true) -> top()
            }
        }
        // print log
        printLog()
    }

    // add x to stack
    private fun push(x: Int) {
        elements.add(x)
    }

    // pop last element and print it if there is no element print -1
    private fun pop() {
        log.append(if(elements.size == 0) -1 else elements.last()).append("\n")
        if (elements.size != 0) { elements.removeLast() }
    }

    // print stack size
    private fun size() {
        log.append(elements.size).append("\n")
    }

    // if stack is empty print 1 else 0
    private fun empty(): Boolean {
        log.append(if(elements.size == 0) 1 else 0).append("\n")
        return elements.size == 0
    }

    // print last element if there is no element print -1
    private fun top() {
        log.append(if(elements.size == 0) -1 else elements.last()).append("\n")
    }

    // print all log
    private fun printLog() {
        println(log)
    }
}