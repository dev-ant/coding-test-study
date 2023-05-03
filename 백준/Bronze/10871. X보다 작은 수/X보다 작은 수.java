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
     
        
        int a, b;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine()," ");
        int value;
        
        for(int i=0;i<a;i++) {
        	value = Integer.parseInt(st.nextToken());
        	if(value<b)
        		sb.append(value).append(" ");
        }
        System.out.println(sb);
        
        br.close();
   
        bw.close();
        

    }
}