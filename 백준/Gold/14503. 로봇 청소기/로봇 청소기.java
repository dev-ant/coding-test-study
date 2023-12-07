import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static int d;
	static int r;
	static int c;
	static int cc = 0;
	static boolean forward;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t=0;
		while(true) {
			//System.out.println("go");
			step1();
			if(!step2()) {
				break;
			}
		}
		
		System.out.println(cc);
		br.close();
	}
	//set cleaned block -1
	static void step1() {
		if(map[r][c]==0) {
			map[r][c] = -1;
			cc++;
		}
	}
	static boolean step2() {
		int sd = d;
		for(int i=0;i<4;i++) {
			//direction change 0->3 3->2 2->1 1->0
			sd = (sd+3)%4;
			//System.out.println("sd, sdr, sdc, map, r, c: "+sd+" "+(r+dr[sd])+" "+(c+dc[sd])+" "+map[r+dr[sd]][c+dc[sd]]+" "+r+" "+c);
			if((map[r+dr[sd]][c+dc[sd]]==0)) {
				forward = true;
				break;
			}
			else if(i==3) {
				forward = false;
			}
		}
		d = sd;
		if(forward) {
			r = r+dr[d];
			c = c+dc[d];
			return true;
		}
		else {
			if(map[r-dr[d]][c-dc[d]]==1) {
				return false;
			}
			else {
				r = r-dr[d];
				c = c-dc[d];
				return true;
			}
		}
		
	}
 }
