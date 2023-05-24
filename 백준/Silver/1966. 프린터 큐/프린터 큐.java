import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> q;
	static int M;
	static int M2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			M2 = M;
			q = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			while(true) {
				if(0==M2&&isMax()) {
					sb.append((N-q.size()+1)+"\n");
					break;
				}
				
				if(isMax()) {
					//System.out.println(q+" 출력함" + M2);
					q.remove(0);
				}
				else {
					//System.out.println(q+" 출력 안함" + M2);
					q.add(q.remove(0));
				}
				M2--;
				if(M2<0) {
					M2 = q.size()-1;
				}
			}
				
		}
		
		br.close();
		System.out.println(sb);
	}
	static boolean isMax() {
		for(int i=1;i<q.size();i++) {
			if(q.get(0)<q.get(i)) {
				return false;
			}
		}
		return true;
	}
}
