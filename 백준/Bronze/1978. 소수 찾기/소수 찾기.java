import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int cnt = 0;
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;
			
			if(num==1) {
				continue;
			}
			
			for(int j=2;j<=Math.sqrt(num);j++) {
				if(num%j==0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				cnt++;
			}
		}
		
		System.out.print(cnt);
		br.close();
	}
}