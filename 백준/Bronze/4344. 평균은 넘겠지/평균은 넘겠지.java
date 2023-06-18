import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[m];
			int sum = 0;
			int cnt = 0;
			double average;
			//각 점수를 배열에 넣어줌 다음 줄로 넘어가면 초기화
			for(int j=0;j<m;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum+=arr[j];
			}
			average = (double)sum/arr.length;
			for(int j=0;j<m;j++) {
				if(arr[j]>average)
					cnt++;
			}
			double result = (double)cnt/arr.length*100;
			System.out.printf("%.3f%%\n",result);
		}
		br.close();
	}
}
