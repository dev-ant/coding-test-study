import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] arr;
	static int [][] calcArr; 
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int [n][];
		
		for(int i=0;i<n;i++) {
			arr[i] = new int [i+1];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				//System.out.println(arr[i][j]+"에 "+(arr[i+1][j]>arr[i+1][j+1]?arr[i+1][j]:arr[i+1][j+1])+"을 더함");
				arr[i][j] += arr[i+1][j]>arr[i+1][j+1]?arr[i+1][j]:arr[i+1][j+1];
			}
			//System.out.println();
		}
		
		System.out.print(arr[0][0]);
		
		br.close();
	}
}