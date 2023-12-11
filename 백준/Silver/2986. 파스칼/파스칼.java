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
        int counter = 0;
        for(int i = N - 1; i >= 1; i--) {
            counter++;
            if(N % i == 0) {
                break;
            }
        }

        System.out.println(counter);
        br.close();
    }
}