import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1;i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());

            // planetary[][1 ... 3] = Cx, Cy, r
            int [][] planetary = new int [n][3];
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                planetary[j][0] = Integer.parseInt(st.nextToken());
                planetary[j][1] = Integer.parseInt(st.nextToken());
                planetary[j][2] = Integer.parseInt(st.nextToken());
            }

            int passing = 0;
            for(int j = 0; j < n; j++) {
                int dx1 = x1 - planetary[j][0];
                int dy1 = y1 - planetary[j][1];
                int dx2 = x2 - planetary[j][0];
                int dy2 = y2 - planetary[j][1];
                int r = planetary[j][2];

                boolean isInsideXY1 = dx1 * dx1 + dy1 * dy1 < r * r;
                boolean isInsideXY2 = dx2 * dx2 + dy2 * dy2 < r * r;
                if(isInsideXY1 != isInsideXY2) {
                    passing++;
                }

            }
            stringBuilder.append(passing).append("\n");
        }
        System.out.println(stringBuilder);
        br.close();
    }
}
