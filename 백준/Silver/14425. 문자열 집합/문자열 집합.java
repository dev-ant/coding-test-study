import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int check;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] setS = new String[N];
        String [] setCheck = new String[M];
        check = 0;

        for (int i = 0; i < N; i++) {
            setS[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            setCheck[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(setCheck[i].equals(setS[j])) {
                    check++;
                }
            }
        }

        System.out.println(check);
        br.close();
    }
}
