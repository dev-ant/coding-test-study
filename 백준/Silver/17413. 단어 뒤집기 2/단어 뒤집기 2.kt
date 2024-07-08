import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()
    println(input.reverseExceptTag())
}

data class Sentence(
    val words: ArrayList<Word>
)

data class Word(
    val isTag: Boolean, var content: String
)

private fun String.reverseExceptTag(): String {
    // create sentence instance
    val sentence = this.toSentence()
    // reverse sentence value except tag
    reverseWords(sentence)
    // sentence instance join to string
    return sentence.words.joinToString("") { it.content }
}

private fun String.toSentence(): Sentence {
    val words = ArrayList<Word>()
    val stringBuilder = StringBuilder((this.replace("<", "<$").replace(">", "%>")))
    stringBuilder.split('<', '>').filter { it.isNotEmpty() }.forEach {
        val word = it.replace("$", "<").replace("%", ">")
        words.add(Word(word.contains("<"), word))
    }
    return Sentence(words)
}

private fun reverseWords(sentence: Sentence) {
    sentence.words.forEach { it ->
        if (!it.isTag) {
            it.content = it.content.split(" ").joinToString(" ") { it.reversed() }
        }
    }
}