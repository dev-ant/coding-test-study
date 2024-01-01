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
        int M = Integer.parseInt(st.nextToken());

        // '|' -> 1, '-' -> 2
        int floorPattern[][] = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                floorPattern[i][j] = str.charAt(j)=='|'?1:2;
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(floorPattern[i][j] == 1) {
                    count++;
                    int xi = i;
                    while(true) {
                        xi++;
                        if(xi<N && floorPattern[xi][j] == 1){
                            floorPattern[xi][j] = 0;
                        }
                        else {
                            break;
                        }
                    }
                }
                else if(floorPattern[i][j] == 2) {
                    count++;
                    int xj = j;
                    while(true) {
                        xj++;
                        if(xj<M && floorPattern[i][xj] == 2){
                            floorPattern[i][xj] = 0;
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    // continue;
                }
            }
        }

        System.out.println(count);
    }

    private static void printFloorPattern(int N, int M, int[][] floorPattern) {
        for(int i = 0; i< N; i++) {
            for(int j = 0; j< M; j++) {
                System.out.print(floorPattern[i][j]);
            }
            System.out.println();
        }
    }
}

// https://www.acmicpc.net/problem/1072