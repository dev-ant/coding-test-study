import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		int cnt = 1;
		
		while(temp>=10) {
			temp /= 10;
			cnt++;
		}
		
		for(int i=N-9*(cnt+1);i<N;i++) {
			int tmp = i;
			int sum = i;
			while(tmp!=0) {
				sum += tmp%10;
				tmp = tmp/10;
			}
			if(sum==N) {
				System.out.print(i);
				break;
			}
			else if(i==N-1) {
				System.out.print(0);
			}
		}
		
		br.close();
		
	}
}
