import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, T;
    public static int[] arrayA;
    public static int[] arrayB;
    public static int[] arrayC;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrayA = new int[N];
        arrayB = new int[N];
        arrayC = new int[N];
        T = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arrayC[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrayC);

        if(N % 2 == 1) {
            System.out.println(1);
        }
        else {
            System.out.println(Math.abs(arrayC[N / 2] - arrayC[N / 2 - 1]) + 1);
        }

        br.close();
    }
}