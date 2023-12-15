import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int continuousSum;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        continuousSum = Integer.MIN_VALUE;
        int[] sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sequenceDP = new int [N];
        sequenceDP[0] = sequence[0];

        for (int i = 1; i < N; i++) {
            sequenceDP[i] = Math.max(sequenceDP[i - 1] + sequence[i], sequence[i]);
        }

        for (int i = 0; i < N; i++) {
            continuousSum = Math.max(continuousSum, sequenceDP[i]);
        }

        System.out.println(continuousSum);
        br.close();
    }
}
