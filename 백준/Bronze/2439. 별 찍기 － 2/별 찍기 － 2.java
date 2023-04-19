import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        
        int n = Integer.parseInt(br.readLine());
        
        
        
        for(int i=1;i<=n;i++) {
            for(int m=1;m<=n;m++) {
            	if(m>=(n-i+1)) {bw.write("*");} 
            	else {bw.write(" ");}
            		
            }
            bw.write("\n");
        }
        
        
        br.close();
        bw.flush();
        bw.close();
        
        
        
        
        
        
    }
}