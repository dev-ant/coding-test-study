

/*
백준 카드 정렬하기
https://www.acmicpc.net/problem/1715

크기 순으로 정렬한
C1 C2 C3 C4 카드가 있다고 치면
C1과 C2를 합치고 다시 C12와 C3를 합치면 다시 C4를 합치면
(C1) + (C2) + (C1 + C2) + (C3) + (C1 + C2 + C3) + C4 =  C1 * 3 + C2 * 3 + C3 * 2 + C4 으로 계산이 된다
카드를 반으로 나눠 절반씩 계속 더하면
(C1) + (C2) + (C3) + (C4) + (C1 + C2) + (C3 + C4) =  C1 * 2 + C2 * 2 + C3 * 2 + C4 * 2

가장 작은 덱 Ca + Cb를 더하고
다시 정렬 시켜 가장 작은 두 덱을 더하면 비용을 최소화할 수 있다
근데 이런 방식으로 풀면 시간초과될 가능성이 높은 거 같은데... 배열이면.. 차라리 priority queue 사용하는 게 효율적일 것 같다
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static Queue<Long> card = new PriorityQueue();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            card.add(Long.parseLong(br.readLine()));
        }

        while(card.size()!=1) {
            long a = card.poll();
            long b = card.poll();
            sum+=a+b;
            card.add(a+b);
        }

        System.out.println(sum);
        br.close();
    }
}