import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int numberLength;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

        numberLength = numbers[0].length();
        int minLength = numberLength;
        Set<Integer> subStringSet;
        for (int length = 1; length <= numberLength; length++) {
            subStringSet = new HashSet<>();

            for(int j = 0; j<N; j++) {
                int subNumber = Integer.parseInt(numbers[j].substring(numberLength - length));
                if(subStringSet.contains(subNumber)) {
                    break;
                }
                else if(j == N - 1) {
                    minLength = length;
                    break;
                }
                else {
                    subStringSet.add(subNumber);
                    // System.out.println(subNumber);
                }
            }

            if(minLength != numberLength) {
                break;
            }
        }

        System.out.println(minLength);
        br.close();
    }
}