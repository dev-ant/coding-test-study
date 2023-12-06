import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int answer;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        // priceArray[i][0] = whole priceArray, priceArray[i][1] = Pi, priceArray[i][2] = Si;
        double [][] priceArray = new double[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            priceArray[i][1] = Integer.parseInt(st.nextToken());
            priceArray[i][2] = Integer.parseInt(st.nextToken());
            priceArray[i][0] = priceArray[i][1] + priceArray[i][2];
        }

        for(int i=0; i<N; i++) {
            double amount = 0;
            int friends = 0;
            double [][] tempArray = new double[N][3];
            for(int j=0; j<N; j++) {
                tempArray[j][0] = priceArray[j][0];
                tempArray[j][1] = priceArray[j][1];
                tempArray[j][2] = priceArray[j][2];
            }
            tempArray[i][1] /= 2;
            tempArray[i][0] = tempArray[i][1] + tempArray[i][2];
            Arrays.sort(tempArray, Comparator.comparingDouble((double[] obj) -> obj[0]));

            /* For Debugging
            System.out.println("i = " + i);
            for(int j=0; j<N; j++) {
                System.out.println(tempArray[j][0] + "   " + tempArray[j][1] + "   " + tempArray[j][2]);
            }
            System.out.println();
             */


            for(int j=0; j<N; j++) {
                if(amount + tempArray[j][0] <= B) {
                    amount += tempArray[j][0];
                    friends++;
                }
                else {
                    break;
                }
            }
            answer = Math.max(friends, answer);
        }

        System.out.println(answer);
        br.close();
    }
}

/*
Input
5 24
4 2
2 0
8 1
6 3
12 5

Output
4
 */