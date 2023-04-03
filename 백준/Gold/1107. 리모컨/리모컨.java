import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	int M = Integer.parseInt(br.readLine());
	int d = 500000;
	int c = 0;
	
	//case1 사용할 수 있는 버튼이 0뿐이라 0만 입력 가능한 경우
	//case2 사용할 수 있는 버튼이 없어 +- 이동만 가능한 경우 
	//case3 가장 근처의 가능한 숫자로 이동하는게 숫자 버튼으로 이동하는 것보다 +- 이동이 빠른 경우
	//case4 가장 근처의 가능한 숫자로 이동하는게 숫자 버튼으로 이동하는 것보다 +- 이동이 느린 경우

	//initial channel
	int ic = 100;
	
	//set broken button
	String [] XButton = new String [M];
	String [] OButton = new String [10-M];
	String ztot = "0123456789";
	if(M!=0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			XButton[i] = st.nextToken();
			if(ztot.contains(XButton[i])) {
				ztot = ztot.replace(XButton[i], "");
			}
		}
	}	
	
	if(N==ic) {
		System.out.println(0);
	}
	else if(XButton.length==10) { //case 2
		System.out.println((int)Math.abs(N-ic));
	}
	else if(XButton.length==9&&ztot.equals("0")) { //case 1
		int r = (int)Math.abs(N-ic)>N+1?N+1:(int)Math.abs(N-ic);
		System.out.println(r);
	}
	else if(M==0) {
		int r = Integer.toString(N).length()<Math.abs(N-100)?Integer.toString(N).length():Math.abs(N-100);
		
		System.out.println(r);
	}
	else {
		//use number button
		
		for(int i=N;;i++) {
			for(int j=0;j<M;j++) {
				//System.out.println("i, j "+i+", "+j);
				if(Integer.toString(i).contains(XButton[j])) {
					j=-1;
					i++;
				}
				else if(j==M-1) {
					//System.out.println(i);
					d = i - N;
					c = i;
					break;
				}
			}
			break;
		}
		for(int i=N;;i--) {
			for(int j=0;j<XButton.length;j++) {
				//System.out.println("i, j "+i+", "+j);
				if(Integer.toString(i).contains(XButton[j])) {
					j=-1;
					i--;
				}
				else if(j == M-1) {
					//System.out.println(i);
					if(d+Integer.toString(c).length()>N-i+Integer.toString(i).length()) {
						d = N-i;
						c = i;
					}
					break;
				}
			}
			break;
		}
		if(Integer.toString(c).length()+d>Math.abs(N-ic)) {
			System.out.println((int)Math.abs(N-ic));
		}
		else {
			System.out.println(Integer.toString(c).length()+d);
		}
	}
	
	br.close();
	}
}
