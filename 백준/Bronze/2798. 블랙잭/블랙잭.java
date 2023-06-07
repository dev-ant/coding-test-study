import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] card = new int[N];
		int max = 0;
		
		
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-2;i++) {
			int num = 0;
			
			if(card[i]<M) {
				num += card[i];
			}
			else {
				continue;
			}
			
			
			for(int j=i+1;j<N-1;j++) {
				
				if(num+card[j]<M) {
					num += card[j];
				}
				else {
					continue;
				}
				
				for(int k=j+1;k<N;k++) {
					
					if(num+card[k]<=M) {
						num += card[k];
						if(max<num&&num<=M) {
							max = num;
						}
						num -= card[k];
					}
					else {
						continue;
					}

				}
				num -= card[j];
			}
			num -= card[i];
		}
		
		System.out.print(max);
		
		br.close();
	}
}