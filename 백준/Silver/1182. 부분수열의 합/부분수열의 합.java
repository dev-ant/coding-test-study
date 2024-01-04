import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] sequence;
    public static int S, N, cases;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        sequence = new int[N];
        cases = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(S == 0 ? cases - 1 : cases);
        br.close();
    }

    private static void dfs(int index, int sum) {
        if(index == N) {
            if (sum == S) {
                cases++;
            }
            return;
        }
        dfs(index + 1, sum + sequence[index]);
        dfs(index + 1, sum);
    }
}