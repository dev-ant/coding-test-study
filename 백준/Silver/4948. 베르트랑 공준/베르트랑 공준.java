import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static boolean [] notPrime;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n; 
		int max=0;
		isPrime();
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) { break; }
			getPrime(n);
		}
		
		System.out.print(sb);
		br.close();
	}
	static void isPrime() {
		notPrime = new boolean [123456*2+1];
		for(int i=2;i<=Math.sqrt(notPrime.length);i++) {
			for(int j=i*i;j<=notPrime.length;j+=i) {
				notPrime[j] = true;
			}
		}
	}
	static void getPrime(int n) {
		int count = 0;
		for(int i=n+1;i<=2*n;i++) {
			if(!notPrime[i]) {
				count++;
			}
		}
		sb.append(count+"\n");
	}
}