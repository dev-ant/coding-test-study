import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] scale = new int [8];
		boolean ascending = true;
		boolean descending = true;
		for(int i=0;i<8;i++) {
			scale[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<8;i++) {
			if((i+1)!=scale[i]) {
				ascending = !ascending;
				break;
			}
		}
		for(int i=0;i<8;i++) {
			if((8-i)!=scale[i]) {
				descending = !descending;
				break;
			}
		}
		if(ascending) {
			System.out.print("ascending");
		}
		else if(descending) {
			System.out.print("descending");
		}
		else {
			System.out.print("mixed");
		}
		br.close();
	}
}