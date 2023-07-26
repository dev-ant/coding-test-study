

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

/*


 */

public class Main {
    static int N;
    static int house [];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        house = new int [N];
        for(int i=0;i<N;i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);
        System.out.println(house[(N-1)/2]);
        br.close();
    }
}
