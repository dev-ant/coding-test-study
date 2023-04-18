import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Stack {
	private int [] intArray;
	private int index;
	StringBuilder sb = new StringBuilder();
	public Stack(int N) {
		intArray = new int [N];
		index = 0;
	}
	void push(int X) {
		intArray[index] = X;
		index++;
	}
	void pop() {
		if(index>0) {
			index--;
			sb.append(intArray[index]+"\n");
		}
		else {
			sb.append(-1+"\n");
		}
		
	}
	void size() {
		sb.append(index+"\n");
	}
	void empty() {
		if(index==0) {
			sb.append(1+"\n");
		}
		else {
			sb.append(0+"\n");
		}
	}
	void top() {
		if(index>0) {
			sb.append(intArray[index-1]+"\n");
		}
		else {
			sb.append(-1+"\n");
		}
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack s = new Stack(N);
		for(int i=0;i<N;i++) {
			String command = br.readLine();
			
			switch(command) {
				case "pop":
					s.pop();
					break;
				case "size":
					s.size();
					break;
				case "empty":
					s.empty();
					break;
				case "top":
					s.top();
					break;
				default:
					String [] push = command.split(" ");
					s.push(Integer.parseInt(push[1]));
					break;
			}
		}
		System.out.print(s.sb);
		br.close();
	}
}