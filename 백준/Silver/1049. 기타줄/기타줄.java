import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_PRICE = 1000;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPriceEach = MAX_PRICE;
        int minPriceSet = MAX_PRICE;

        for (int i = 1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            minPriceSet = Math.min(minPriceSet, Integer.parseInt(st.nextToken()));
            minPriceEach = Math.min(minPriceEach, Integer.parseInt(st.nextToken()));
        }

        int minAmount = Math.min((N / 6) * minPriceSet, N * minPriceEach);
        if(N % 6 != 0) {
            minAmount = Math.min(N * minPriceEach, (N / 6 + 1) * minPriceSet);
            minAmount = Math.min(minAmount, (N / 6) * minPriceSet + (N % 6) * minPriceEach);
        }

        System.out.println(minAmount);
        // br.close();
    }
}
