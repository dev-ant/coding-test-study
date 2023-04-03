

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    연구소
    인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
    연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
    일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
    https://www.acmicpc.net/problem/14502
 */

public class Main {

    static int N, M;
    static int [][] lab;
    static int safe = 0;
    static int [] dx = new int [] {1,-1,0,0};
    static int [] dy = new int [] {0,0,-1,1};
    static Queue<int []> virus = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int [N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j]==2) {
                    virus.add(new int [] {i, j});
                }
            }
        }
        brutal_force_dfs(0);
        System.out.println(safe);
        br.close();
    }

    //build wall by brutal force
    static void brutal_force_dfs(int w) {
        if(w==3) {
//            System.out.println("brutal force dfs");
//            for(int k=0;k<N;k++) {
//                for(int l=0;l<M;l++) {
//                    System.out.print(lab[k][l]+" ");
//                }
//                System.out.println();
//            }
            simulInfect();
        }
        else {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(lab[i][j]==0) {
                        lab[i][j] = 1;
                        brutal_force_dfs(w+1);
                        lab[i][j] = 0;
                    }
                }
            }
        }
    }

    //simulate infect situation
    static void simulInfect() {
        int [][] virtual_lab = new int [N][M];
        Queue<int []> virtual_virus = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                virtual_lab[i][j] = lab[i][j];
                if(virtual_lab[i][j]==2) {
                    virtual_virus.add(new int [] {i, j});
                }
            }
        }

        //System.out.println("virtual_virus.size() = " + virtual_virus.size());
        while(!virtual_virus.isEmpty()) {
            int [] k = virtual_virus.poll();
            for(int i=0;i<4;i++) {
                int x = k[0] + dx[i];
                int y = k[1] + dy[i];
//                System.out.println("x = " + x);
//                System.out.println("y = " + y);

                if(x>=0 && x<N && y>=0 && y<M) {
                    //System.out.println("virtual_lab = " + virtual_lab[x][y]);
                    if(virtual_lab[x][y]==0) {
                        virtual_lab[x][y] = 2;
                        virtual_virus.add(new int [] {x, y});
                    }
                }
;            }
        }
//            for(int k=0;k<N;k++) {
//                for(int l=0;l<M;l++) {
//                    System.out.print(virtual_lab[k][l]+" ");
//                }
//                System.out.println();
//            }
//        System.out.println();
        countSafeArea(virtual_lab);
    }

    //
    static void countSafeArea(int [][] virtual_lab) {
        int sa = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(virtual_lab[i][j]==0) {
                    sa++;
                }
            }
        }
//        if(sa>safe) {
//            System.out.println("new!!!!!!!!!!");
//            for(int k=0;k<N;k++) {
//                for(int l=0;l<M;l++) {
//                    System.out.print(virtual_lab[k][l]+" ");
//                }
//                System.out.println();
//            }
//        }
        safe = sa>safe?sa:safe;
    }
}
