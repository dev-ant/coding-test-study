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
        long L = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long H = Integer.parseInt(st.nextToken());

        double A = Math.cbrt((double)L*W*H/N);
        // System.out.println(A);
        double BTM [] = {0, A/2, A};
        double pre = A;
        double maxA = A;
        while(true) {

            if((long)(L/BTM[1]) * (long)(W/BTM[1]) * (long)(H/BTM[1]) >= N) {
                BTM[0] = BTM[1];
                maxA = BTM[1];
            }
            else {
                BTM[2] = BTM[1];
            }
            pre = BTM[1];
            BTM[1] = (BTM[0] + BTM[2]) / 2;
            // System.out.println("top = " + BTM[2] + " bottom = " + BTM[0]);

            if(pre == BTM[1]) {
                break;
            }
        }

        System.out.println(maxA);
    }
}

// https://www.acmicpc.net/problem/1166
// 52.300000000000004
// 52.300000000000004
// 52.30000000000001