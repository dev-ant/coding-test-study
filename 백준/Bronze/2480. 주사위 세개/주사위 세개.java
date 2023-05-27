import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        int N3 = Integer.parseInt(st.nextToken());
        int resultN;

        if(N1==N2&&N1==N3) {
            resultN = 10000 + N1*1000;
        }
        else if(N1==N2) {
            resultN = 1000 + N1*100;
        }
        else if(N2==N3) {
            resultN = 1000 + N2*100;
        } 
        else if (N1==N3) {
            resultN = 1000 + N3*100;
        } 
        else {
            int[] arr = {N1, N2, N3};
            Arrays.sort(arr);
            resultN = arr[2] * 100;
        }

        System.out.println(resultN);
        br.close();
    }
}
