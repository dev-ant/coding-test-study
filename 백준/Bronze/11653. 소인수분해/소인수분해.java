import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		while(true) {
			if(N==1) {
				break;
			}
			for(int i=2;i<=N;i++) {
				if(N%i==0) {
					//System.out.println(i+"추가완료!");
					sb.append(i).append("\n");
					N /= i;
					break;
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}