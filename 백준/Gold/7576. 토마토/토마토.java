import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomato = new int[N][M];
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            for(int i=0;i<4;i++) {
                int [] t_t = new int [] {(t[0]+dx[i]), (t[1]+dy[i])};
                //System.out.println("check "+t_t[0]+" "+t_t[1]);
                if(t_t[0]<0||t_t[1]<0||t_t[0]>=N||t_t[1]>=M) {
                    continue;
                }
                else if(tomato[t_t[0]][t_t[1]]==0) {
                    q.add(new int[] {t_t[0], t_t[1]});
                    tomato[t_t[0]][t_t[1]]=tomato[t[0]][t[1]]+1;
                }
                else {
                    continue;
                }
            }
        }
        /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(tomato[i][j]+" ");
            }
            System.out.println();
        }
        */
        int max = 0;
        boolean zero = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(max<tomato[i][j]) {
                    max = tomato[i][j];
                }
                else if(tomato[i][j]==0) {
                    zero = true;
                }
            }
        }

        if(zero) {
            System.out.println(-1);
        }
        else if(max==1) {
            System.out.println(0);
        }
        else {
            System.out.println(max-1);
        }
        br.close();
    }
}
