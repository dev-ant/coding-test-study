import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// dice row, column, XY
	static int[] diceR;
	static int[] diceC;
	static int[] diceXY;
	static int[][] map;
	static int N;
	static int M;
	static boolean pass;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		int[] command = new int[K];
		map = new int[N][M];
		diceR = new int[4];
		diceC = new int[4];
		diceXY = new int[] { x, y };

		// set map info
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// set command
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		// command execution
		for (int i = 0; i < K; i++) {
			//System.out.println("command" + command[i]);
			pass = true;
			roll(command[i]);
			diceChange();
			if (pass) {
				sb.append(diceR[1] + "\n");
			}
			//System.out.println(diceXY[0] + ", " + diceXY[1]+"\n\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void roll(int c) {
		int temp;
		switch (c) {
		case 1:
			diceXY[1]++;
			if (!commandPossible()) {
				diceXY[1]--;
				return;
			}
			temp = diceR[3];
			diceR[3] = diceR[2];
			diceR[2] = diceR[1];
			diceR[1] = diceR[0];
			diceR[0] = temp;
			diceC[1] = diceR[1];
			diceC[3] = diceR[3];
			break;
		case 2:
			diceXY[1]--;
			if (!commandPossible()) {
				diceXY[1]++;
				return;
			}
			temp = diceR[0];
			diceR[0] = diceR[1];
			diceR[1] = diceR[2];
			diceR[2] = diceR[3];
			diceR[3] = temp;
			diceC[1] = diceR[1];
			diceC[3] = diceR[3];
			break;
		case 3:
			diceXY[0]--;
			if (!commandPossible()) {
				diceXY[0]++;
				return;
			}
			temp = diceC[0];
			diceC[0] = diceC[1];
			diceC[1] = diceC[2];
			diceC[2] = diceC[3];
			diceC[3] = temp;
			diceR[1] = diceC[1];
			diceR[3] = diceC[3];
			break;
		case 4:
			diceXY[0]++;
			if (!commandPossible()) {
				diceXY[0]--;
				return;
			}
			temp = diceC[3];
			diceC[3] = diceC[2];
			diceC[2] = diceC[1];
			diceC[1] = diceC[0];
			diceC[0] = temp;
			diceR[1] = diceC[1];
			diceR[3] = diceC[3];
			break;
		}
		// System.out.println(diceXY[0] + " " + diceXY[1]);
	}

	static boolean commandPossible() {
		if (diceXY[0] > N - 1 || diceXY[1] > M - 1 || diceXY[0] < 0 || diceXY[1] < 0) {
			pass = false;
			// System.out.println("command Impossible");
			return false;
		} else {
			return true;
		}
	}

	static void diceChange() {
		if(pass) {
			if (map[diceXY[0]][diceXY[1]] == 0) {
				map[diceXY[0]][diceXY[1]] = diceC[3];
			} else {
				diceC[3] = map[diceXY[0]][diceXY[1]];
				diceR[3] = map[diceXY[0]][diceXY[1]];
				map[diceXY[0]][diceXY[1]] = 0;
			}
		}
		/*
		System.out.println("dice"); 
		System.out.println("  "+diceC[0]+"  ");
		System.out.println(diceR[0]+" "+diceC[1]+" "+diceR[2]+" "+diceR[3]);
		System.out.println("  "+diceC[2]+"  ");
		System.out.println("  "+diceC[3]+"  \n");
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		*/
	}
}
