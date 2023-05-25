import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int [][] video;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int [N+1][N+1];

        for(int i=1;i<=N;i++) {
            String str = br.readLine();
            for(int j=1;j<=N;j++) {
                video[i][j] = Integer.parseInt(str.charAt(j-1)+"");
                //System.out.print(video[i][j]);
            }
            //System.out.println();
        }

        QTree(1, 1, N);
        System.out.println(sb);
        br.close();
    }

    static void QTree(int x, int y, int S) {
        if(check(x, y, S)) {
            sb.append(video[x][y]+"");
        }
        else {
            sb.append("(");
            QTree(x, y, S/2);
            QTree(x, y+S/2, S/2);
            QTree(x+S/2, y, S/2);
            QTree(x+S/2, y+S/2, S/2);
            sb.append(")");
        }
    }
    static boolean check(int x, int y, int S) {
        int zo = video[x][y];
        //System.out.println("check "+x+", "+y+", "+S);
        /*for(int i=x;i<x+S;i++) {
            for(int j=y;j<y+S;j++) {
                System.out.print(video[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=x;i<x+S;i++) {
            for(int j=y;j<y+S;j++) {
                if(zo!=video[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

