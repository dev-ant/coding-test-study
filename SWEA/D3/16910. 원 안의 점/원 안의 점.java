import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++) {
            sb.append("#").append(i).append(" ").append(countInsidePoint(br)).append("\n");
        }
        System.out.println(sb);
    }

    private static int countInsidePoint(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());

        // count point inside circle in first side
        int insidePoint = 4 * N + 1;
        int oneSidePoint = 0;
        for(int x=1;x<=N;x++) {
            for(int y=1;y<=N;y++) {
                if((x * x + y * y) <= N * N) {
                    oneSidePoint++;
                }
            }
        }
        // Multiply first side inside point and add to inside point
        return insidePoint += 4 * oneSidePoint;
    }
}