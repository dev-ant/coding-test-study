import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Tomato {
    int R, C, H;
    Tomato(int k, int j, int i) {
        R = k;
        C = j;
        H = i;
    }
}
public class Main {
    static int [][][] box;
    static int M, N, H;
    static int rD [] = {1,-1,0,0,0,0};
    static int cD [] = {0,0,1,-1,0,0};
    static int hD [] = {0,0,0,0,1,-1};
    static Queue<Tomato> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int [M][N][H];

        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++) {
                    box[k][j][i] = Integer.parseInt(st.nextToken());
                    if(box[k][j][i]==1) {
                        //System.out.println(k+" "+j+" "+i);
                        q.add(new Tomato(k,j,i));
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Tomato t = q.poll();
            for(int i=0;i<6;i++) {
                if(isRipe((t.R+rD[i]), (t.C+cD[i]), (t.H+hD[i]))) {
                    //System.out.println("check "+(t.R+rD[i])+" "+(t.C+cD[i])+" "+(t.H+hD[i]));
                    box[t.R+rD[i]][t.C+cD[i]][t.H+hD[i]] = box[t.R][t.C][t.H] + 1;
                    q.add(new Tomato((t.R+rD[i]), (t.C+cD[i]), (t.H+hD[i])));
                }
            }
        }
        /*
        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    System.out.print(box[k][j][i]+" ");
                }
                System.out.println();
            }
        }
        */
        boolean zero = false;
        int max = 1;
        for(int i=0;i<H;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    if(box[k][j][i]==0) {
                        zero = true;
                        break;
                    }
                    if(box[k][j][i]>max) {
                        max = box[k][j][i];
                    }
                }
            }
        }
        if(max == 1&&!zero) {
            System.out.println(0);
        }
        else if(zero) {
            System.out.println(-1);
        }
        else {
            System.out.println(max-1);
        }
        br.close();
    }
    static boolean isRipe(int r, int c, int h) {
        if(r<0||c<0||h<0||r>=M||c>=N||h>=H) {
            return false;
        }
        else if(box[r][c][h]==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
