

/*
경쟁적 전염
https://www.acmicpc.net/problem/18405

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int S, X, Y;
    static int [][] test_tube;
    static int [] dx = {1,-1,0,0,};
    static int [] dy = {0,0,1,-1};
    static Queue<int []> [] static_queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        test_tube = new int [N][N];
        static_queue = new Queue[K+1];

        for(int i=0;i<=K;i++) {
            static_queue[i] = new LinkedList<>();
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                test_tube[i][j] = Integer.parseInt(st.nextToken());
                if(test_tube[i][j]!=0) {
                    static_queue[test_tube[i][j]].add(new int [] {i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        bfs(0);
        br.close();
    }

    static void bfs(int s) {
        //System.out.println("s = " + s);
        if(s==S) {
            if(test_tube[X-1][Y-1]==0) {
                System.out.println(0);
            }
            else {
                System.out.println(test_tube[X-1][Y-1]);
            }
        }
        else {
            for(int i=1;i<=K;i++) {
                Queue<int []> q2 = new LinkedList<>();

                while(!static_queue[i].isEmpty()) {
                    int [] p = static_queue[i].remove();
                    for(int j=0;j<4;j++) {
                        int px = p[0] + dx[j];
                        int py = p[1] + dy[j];
                        if(px>=0 && py>=0 && px<N && py<N && test_tube[px][py] == 0) {
                            test_tube[px][py] = i;
                            q2.add(new int [] {px, py});
                        }
                    }
                }
                static_queue[i] = q2;
            }
            /*
            System.out.println("s = " + s);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    System.out.print(test_tube[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

             */
            bfs(s+1);
        }
    }

}
