import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int [] A;
    static int [] B;
    static int N;
    static long S = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int [N];
        B = new int [N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<=100;i++) {
            int n = 0;
            for(int j=0;j<N;j++) {
                if(A[j]==i) {
                    n++;
                }
            }
            if(n>0) {
                //System.out.println("find "+n+" "+i+"s in A");
                getB(i, n);
            }
        }
        System.out.println(S);
        br.close();
    }
    static void getB(int x, int n) {
        for (int i=100;i>=0;i--) {
            for(int j=0;j<N;j++) {
                if(B[j]==i&&n>0) {
                    //System.out.println(x+" * "+B[j]);
                    S+=B[j]*x;
                    B[j]=-1;
                    n--;
                }
            }
            if(N==0) {
                break;
            }
        }
    }
}

