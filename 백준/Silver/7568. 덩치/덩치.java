import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=0;i<N;i++) {
			int num = 1;
			
			for(int j=0;j<N;j++) {
				//i==j인 경우도 생각해야됨
				if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]) {
					num++;
				}
			}
			sb.append(num+" ");
		}
		
		System.out.print(sb);
		
		br.close();
		
	}
}