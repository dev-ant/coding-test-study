import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        printOutput(calculateSequence(L, N), N);
        br.close();
    }

    private static int calculateSequence(int L, int N) {
        for(int i = L; i <= 100; i++) {
            int sum = 0;
            for(int j = 1; j <= i; j++) {
                sum += j;
            }
            // System.out.println(sum);
            if((N - sum) % i == 0) {
                return ((N - sum) / i + 1);
            }
        }
        return -1;
    }

    private static void printOutput(int o, int N) {
        if(o < 0) {
            System.out.println("-1");
        }
        else {
            for(int sum = o; sum <= N; sum += o) {
                System.out.print(o);
                if(sum!=N) {
                    System.out.print(" ");
                }
                o++;
            }
        }
    }
}

/*
L = 2 N = 홀수
(1 + ... + N) + N * K
L = 3 N = 짝수
N / 3 - 1, N / 3, N / 3 +1
L = 4 N = 홀수


L = 5

L = 6

 */