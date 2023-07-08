
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 특정 거리의 도시 찾기 문제
    https://www.acmicpc.net/problem/18352

 */

public class Main {
    static int N, M, K, X;
    static int [] shortest_distance;
    static List<ArrayList<Integer>> road = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        shortest_distance = new int [N+1];
        int[] dist = new int [N+1];
        for(int i=0;i<=N;i++) {
            road.add(new ArrayList<>());
            dist[i] = -1;
        }
        dist[X] = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            road.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> dest = new LinkedList<>();
        dest.add(X);
        while(!dest.isEmpty()) {
            int start = dest.poll();
            for(int i=0;i<road.get(start).size();i++) {
                int end = road.get(start).get(i);
                if(dist[end]==-1) {
                    dist[end] = dist[start] + 1;
                    dest.add(end);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            if(dist[i]==K) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.length()==0?-1:sb);
        br.close();
    }
}


/*
        예제 입력 1
        4 4 2 1
        1 2
        1 3
        2 3
        2 4
        예제 출력 1
        4
        예제 입력 2
        4 3 2 1
        1 2
        1 3
        1 4
        예제 출력 2
        -1
        예제 입력 3
        4 4 1 1
        1 2
        1 3
        2 3
        2 4
        예제 출력 3
        2
        3
 */