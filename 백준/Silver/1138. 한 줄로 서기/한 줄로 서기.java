import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] numbers;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leftBiggerMan[] = new int[N];
        int line[] = new int[N];


        for (int i = 0; i < N; i++) {
            leftBiggerMan[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int order = leftBiggerMan[i-1];
            for(int j = 0; j <N; j++) {
                // Not order yet
                if(order != 0) {
                    // It's bigger than you
                    if(line[j] == 0) {
                        order--;
                    }
                }
                // Now it's my turn
                else if(line[j] == 0) {
                    line[j] = i;
                    break;
                }
            }
        }

        printLine(N, line);
        br.close();
    }

    private static void printLine(int N, int[] line) {
        for (int i = 0; i < N; i++) {
            System.out.print(line[i] + " ");
        }
        System.out.println();
    }
}