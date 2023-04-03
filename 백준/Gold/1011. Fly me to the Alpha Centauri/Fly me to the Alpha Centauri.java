import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int distance = y-x;

			int prime = (int)Math.sqrt(distance);
			
			if(prime == Math.sqrt(distance)) {
				sb.append(prime*2-1).append("\n");
			}
			else if(distance-prime*prime<=prime) {
				sb.append(prime*2).append("\n");
			}
			else {
				sb.append(prime*2+1).append("\n");
			}
			
		}
		System.out.print(sb);
		
		br.close();
	}
}