import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int [][] connect;
    static boolean [] virus;
    static int M, N;
    static int infected = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        connect = new int[N][2];
        virus = new boolean[M+1];
        virus[1] = true;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            connect[i][0] = Integer.parseInt(st.nextToken());
            connect[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++) {
            int c1 = connect[i][0];
            int c2 = connect[i][1];
            computer_infect(c1, c2);
        }
        System.out.println(infected);
        br.close();
    }

    static void computer_infect(int c1, int c2) {
        if(virus[c1]^virus[c2]) {
            int ci = virus[c1]?c2:c1;
            virus[ci] = true;
            for (int i=0;i<N;i++) {
                if(connect[i][0]==ci||connect[i][1]==ci) {
                    computer_infect(connect[i][0], connect[i][1]);
                }
            }
            infected++;
        }
    }
}
