import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] block = new int[N][M];
		int min=-1;
		int max=0;
		
		HashSet<Integer> height = new HashSet<Integer>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<M;j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
				if(min==-1) {
					max=block[i][j];
					min=block[i][j];
				}
				else if(min>block[i][j]) {
					min=block[i][j];
				}
				else if(max<block[i][j]) {
					max=block[i][j];
				}
			}
		}
		
		int minTime = -1;
		int maxHeight = 0;
		
		//입력받은 블럭의 모든 높이를 탐색
		for(int m=min;m<=max;m++) { 
			Integer h = m;
			int time=0;
			int Bvar = B; //초기 B의 값을 Bvar에 넣어서 계속 재활용
			
			for(int i=0;i<N;i++) {
		
				for(int j=0;j<M;j++) {
					if(block[i][j]>h) {
						time+=2*(block[i][j]-h);
						Bvar+=block[i][j]-h;
					}
					else if(block[i][j]<h) {
						time+=(h-block[i][j]);
						Bvar-=h-block[i][j];
					}
					
				}
			}
			//System.out.println(time+" "+h+" "+Bvar);
			if(Bvar>=0) {
				if(minTime==-1) {
					minTime = time;
					maxHeight = h;
				}
				else if(minTime>time) {
					minTime = time;
					maxHeight = h;
				}
				else if(minTime==time&&maxHeight<h) {
					maxHeight = h;
				}
			}
			
		}
		
		System.out.print(minTime+" "+maxHeight);
		
		br.close();
	}
}
