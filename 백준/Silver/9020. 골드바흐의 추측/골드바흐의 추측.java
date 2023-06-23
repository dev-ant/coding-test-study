import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static boolean [] notPrime;
	static int [] testcase;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		testcase = new int [n];
		int max=0;
		for(int i=0;i<n;i++) {
			testcase[i]  = Integer.parseInt(br.readLine());
			if(max<testcase[i]) { max=testcase[i]; }
		}
		isPrime(max);
		for(int i=0;i<n;i++) {
			getTwo(testcase[i]);
		}
		System.out.print(sb);
		br.close();
	}
	static void isPrime(int n) {
		notPrime = new boolean [n+1];
		for(int i=2;i<=Math.sqrt(n);i++) {
			for(int j=i*i;j<=n;j+=i) {
				notPrime[j] = true;
			}
		}
	}
	static void getTwo(int n) {
		int dis = n;
		String str = "";
		for(int i=n/2;i>=2;i--) {
			if(!notPrime[i]&&!notPrime[n-i]) {
				str = i + " " + (n-i);
				break;
			}
		}
		sb.append(str+"\n");
	}
}