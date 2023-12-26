import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] numbers;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numbers = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(findBiggestRectangle(N, M));
        br.close();
    }

    private static int findBiggestRectangle(int N, int M) {
        for (int length = Math.min(N, M); length > 0; length--) {
            for(int x = 0; x+length-1 < M; x++) {
                for(int y = 0; y+length-1 < N; y++) {
                    // System.out.println("length = " + length + " x = " + x + " y = " + y + " length+x-1 = " + (length+x-1) + " length+y-1 = " + (length+y-1));
                    if(numbers[y][x] == numbers[y][length+x-1] && numbers[y][x] == numbers[length+y-1][x] && numbers[y][x] == numbers[length+y-1][length+x-1]) {
                        // System.out.println("FOUND!!");
                        return length * length;
                    }
                }
            }
        }
        return 1;
    }

    private static void printNumbers(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}