import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int d = GCF(N, M);

        sb.append(d+"\n");
        sb.append(N * M / d);

        System.out.println(sb);
        br.close();
    }

    static int GCF(int a, int b) {

        while(b!=0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }
}
