import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int x1,x2,y1,y2,r1,r2;
		double d;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			d = Math.sqrt( ((double)x1-(double)x2)*((double)x1-(double)x2) + ((double)y1-(double)y2)*((double)y1-(double)y2));
			
			if(d==0&&r1==r2) {
				sb.append(-1).append("\n");
			}
			else if(Math.abs(r1-r2)<d&&d<Math.abs(r1+r2)) {
				sb.append(2).append("\n");
			}
			else if(Math.abs(r1-r2)==d||r1+r2==d) {
				sb.append(1).append("\n");
			}
			else if(Math.abs(r1-r2)>d||r1+r2<d||d==0) {
				sb.append(0).append("\n");
			}
			
		}
		
		System.out.print(sb);
		
		br.close();
	}
}