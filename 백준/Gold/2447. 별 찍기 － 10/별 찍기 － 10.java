import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		char[][] star = new char[N][N];
		
		for(int i=0;i<N;i++) {
		
			for(int j=0;j<N;j++) {
				star[i][j] = '*';
			}
		}
		
		reStar(0,0,star,N);
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
		
	}
	
	public static void reStar(int X, int Y, char[][] star, int N) {
		if(N>=3) {
			for(int i=N/3;i<N/3*2;i++) {
				
				for(int j=N/3;j<N/3*2;j++) {
					star[X+i][Y+j] = ' ';
				}
			}
			
			
			for(int i=0;i<3;i++) {
				
				for(int j=0;j<3;j++) {
					reStar(X+N/3*i, Y+N/3*j, star, N/3);
				}
			}
		}
	}
}