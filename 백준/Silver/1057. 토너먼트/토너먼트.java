import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int KIM = Integer.parseInt(st.nextToken());
        int LIM = Integer.parseInt(st.nextToken());

        int match = 0;
        while(KIM != LIM) {
            match++;
            KIM = (int) Math.round((double) KIM / 2);
            LIM = (int) Math.round((double) LIM / 2);
            // System.out.println("MATCH " + match + " = KIM = " + KIM + " LIM = " + LIM);
        }

        System.out.println(match);
    }
}