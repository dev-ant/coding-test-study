import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n;
		int[] arr = new int[11];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for(int j=3;j<arr.length;j++) {
			arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
		}
		
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			sb.append(arr[n]).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}
