import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[Integer.parseInt(br.readLine())];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			arr[i] = br.readLine();
		}
		int cnt = 0;
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			for(int m=0;m<arr[i].length();m++) {
				if(arr[i].charAt(m) == 'O') {
					cnt++;
				}
				else
					cnt=0;
				sum+=cnt;
			}
			sb.append(sum).append("\n");
			cnt=0;
			sum=0;
		}
		System.out.println(sb);
		br.close();	
	}
}