import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(buildBridge(N, M)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static BigInteger buildBridge(int N, int M) {
        BigInteger sum = BigInteger.ONE;
        for(int i = 1; i <= N; i++) {
            sum = sum.multiply(BigInteger.valueOf(M));
            // System.out.println("* " + M + " sum= " + sum);
            M--;
        }
        for(int i = 1; i <= N; i++) {
            sum = sum.divide(BigInteger.valueOf(i));
            // System.out.println("/ " + i + " sum= " + sum);
        }
        return sum;
    }
}