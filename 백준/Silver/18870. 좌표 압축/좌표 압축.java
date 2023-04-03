import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> m = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int [N];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] sArr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sArr[i] = arr[i];
		}
		Arrays.sort(sArr);
		
		int temp = 0;
		for(int i=0;i<N;i++) {
			if(!m.containsKey(sArr[i])) {
				m.put(sArr[i], temp);
				temp++;
			}
		}
		
		for(int i=0;i<N;i++) {
			sb.append(m.get(arr[i])+" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
