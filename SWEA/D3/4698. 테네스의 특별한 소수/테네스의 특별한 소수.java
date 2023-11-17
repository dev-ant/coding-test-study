import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] prime = eratos((int) Math.pow(10, 6));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T ;i++) {
            int specialPrime = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String D = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // Check prime number string contains $D
            for(int j = A; j <= B; j++) {
                if(prime[j]&&String.valueOf(j).contains(D)) {
                    specialPrime++;
                }
            }
            sb.append("#").append(i).append(" ").append(specialPrime).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    // return array of prime number from 1 to param - N, calc with Sieve of Eratosthenes
    public static boolean [] eratos(int N) {
        boolean [] prime = new boolean [N+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i <= Math.sqrt(N); i++) {

            // If number is true, check multiple of this number false
            if(prime[i]) {
                for(int j = i * i; j <= N; j+=i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}

/*
Input 1
2
3 10 30
7 1 1000000

Output 2
#1 2
#2 43506
 */