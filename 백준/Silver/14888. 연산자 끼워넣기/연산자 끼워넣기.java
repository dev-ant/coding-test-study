

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] A;
    static int [] operator = {0,0,0,0};
    static int MAX = -1000000000;
    static int MIN = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int [N];
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(A[0], 1, operator);
        System.out.println(MAX+"\n"+MIN);
        br.close();
    }
    static void dfs(int result, int depth, int [] op) {
        if(depth==N) {
            MIN = (int)Math.min(MIN, result);
            MAX = (int)Math.max(MAX, result);
            return;
        }
        else {
            if(op[0]>0) {
                dfs(result+A[depth], depth+1, new int [] {op[0]-1, op[1], op[2], op[3]});
            }
            if(op[1]>0) {
                dfs(result-A[depth], depth+1, new int [] {op[0], op[1]-1, op[2], op[3]});
            }
            if(op[2]>0) {
                dfs(result*A[depth], depth+1, new int [] {op[0], op[1], op[2]-1, op[3]});
            }
            if(op[3]>0) {
                dfs(result/A[depth], depth+1, new int [] {op[0], op[1], op[2], op[3]-1});
            }
        }
    }
}
