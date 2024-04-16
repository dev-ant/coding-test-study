class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        answer += (1..n).filter { n % it == 0 }.sum()
        return answer
    }
}