import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] LAN = new int[K];
		long min = 0;
		long max = 0;

		for (int i = 0; i < K; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
			if (max < LAN[i]) {
				max = LAN[i];
			}

		}
		max++;
		int t = 0;
		while (min < max) {
			int cnt = 0;
			long mid = (max + min) / 2;
			t++;
			for (int k : LAN) {
				cnt += (k / mid);
			}
			//System.out.println(t+"번째 시도 "+mid+"으로 나눈 결과: "+cnt+"개 범위는 "+min+"~"+max);
			// 필요 이상으로 짧게 자른 경우
			if (cnt >= N) {
				min = mid + 1;
				//ystem.out.println("좀 더 길게 자르겠음\n");
			}
			// 필요 이상으로 길게 자른 경우
			else {
				max = mid;
				//System.out.println("좀 더 짧게 자르겠음\n");
			}
		}

		System.out.println(min - 1);
		br.close();
	}
}