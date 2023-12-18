import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] relation = new int[N][N];

        for (int i = 0; i < N; i++) {
            String relationString = br.readLine();
            for (int j = 0; j < N; j++) {
                relation[i][j] = Character.toString(relationString.charAt(j)).equals("Y") ? 1 : 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (relation[i][j] == 1) {
                    int row = j;
                    for (int k = 0; k < N; k++) {
                        if(row == j && k == i) {
                            continue;
                        }
                        if(relation[row][k] == 1 && relation[i][k] == 0) {
                            relation[i][k] = 2;
                        }
                    }
                }
            }
        }

        int mostPopular = 0;
        for (int i=0; i<N; i++) {
            int popular = 0;
            for(int j=0; j<N; j++) {
                if (relation[i][j] != 0) {
                    popular++;
                }
            }
            mostPopular = Math.max(mostPopular, popular);
        }

        // For debugging
        /* for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(relation[i][j] + " ");
            }
            System.out.println();
        } */

        System.out.println(mostPopular);
        br.close();
    }
}

/*
Input
5
NYNNN
YNYNN
NYNYN
NNYNY
NNNYN
Output
4

 */