import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> pokeMon1 = new HashMap<>();
        HashMap<Integer, String> pokeMon2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++) {
        	String str = br.readLine();
        	pokeMon1.put(str, i);
        	pokeMon2.put(i, str);
        }

        for(int i=0;i<M;i++) {
        	String str = br.readLine();
        	if(isInt(str)) {
        		sb.append(pokeMon2.get(Integer.parseInt(str))).append("\n");
        	}
        	else {
        		sb.append(pokeMon1.get(str)).append("\n");
        	}
        }
        System.out.print(sb);
        br.close();
    }
    static boolean isInt(String str) {
    	try {
    		int num = Integer.parseInt(str);
    		return true;
    	}
    	catch (NumberFormatException e) {
    		return false;
    	}
    }
}