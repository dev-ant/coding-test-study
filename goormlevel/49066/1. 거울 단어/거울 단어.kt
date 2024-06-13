import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
	val result = StringBuilder()
	(1..readLine().toInt()).map {
		readLine()
	}.forEach {
		result.append(isMirrorWord(it)).append("\n")
	}
	print(result)
}

private fun isMirrorWord(word: String):String {
	for(i in 0..(word.length / 2)) {
		if(!isMirrorAlphabet(Pair(word[i], word[word.length - 1 - i]))) {
			return "Normal"
		}
	}	
	return "Mirror"
}

private fun isMirrorAlphabet(pair: Pair<Char, Char>): Boolean {
	val mirrorAlphabets = arrayOf(
		Pair('b','d'), Pair('i','i'), Pair('l','l'), Pair('m','m'), 
		Pair('n','n'), Pair('o','o'), Pair('p','q'), Pair('s','z'), 
		Pair('u','u'), Pair('v','v'), Pair('w','w'), Pair('x','x'))
	
	return mirrorAlphabets.contains(Pair(pair.first, pair.second)) or
            mirrorAlphabets.contains(Pair(pair.second, pair.first))
}