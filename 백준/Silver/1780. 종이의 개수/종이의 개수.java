import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] paper;
    static int N;
    static int p = 0, z = 0, m = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int [N+1][N+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(1,1,N);
        System.out.println(m+"\n"+z+"\n"+p);
        br.close();
    }

    static void recur(int x, int y, int S) {
        if(isPossible(x, y, S)) {
            if(paper[x][y]==-1) {
                m++;
            }
            else if(paper[x][y]==0) {
                z++;
            }
            else {
                p++;
            }
        }
        else {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    recur(x+S/3*i, y+S/3*j, S/3);
                }
            }
        }
    }

    static boolean isPossible(int x, int y, int S) {
        int v = paper[x][y];
        //System.out.println("check");
        /*for(int i=x;i<x+S;i++) {
            for(int j=y;j<y+S;j++) {
                System.out.print(paper[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=x;i<x+S;i++) {
            for(int j=y;j<y+S;j++) {
                if(v!=paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

