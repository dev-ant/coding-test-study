import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<Integer> queue;
    public static int sumCount;
    public static int [] setA;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        setA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        intiQueue(N);

        // ::For debugging
        //printQueueAll();

        for(int i=0; i < setA.length; i++) {
            moveQueueMinimum(setA[i]);
        }

        System.out.println(sumCount);
        br.close();
    }

    private static void moveQueueMinimum(int elementalA) {
        // Calculate minimum move between moving left and right
        for(int i=0; i<queue.size(); i++) {
            if(queue.get(i) == elementalA) {
                if(i <= queue.size() - i) {
                    // ::For debugging
                    // System.out.println("MOVE LEFT " + i);
                    moveQueueLeft(i);
                }
                else {
                    // ::For debugging
                    // System.out.println("MOVE RIGHT " + (queue.size() - i));
                    moveQueueRight(queue.size() - i);
                }
                sumCount += Math.min(i, queue.size() - i);
                queue.remove(0);
                // ::For debugging
                // printQueueAll();
            }
        }
    }

    private static void printQueueAll() {
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    private static void moveQueueRight(int count) {
        // Move right Queue at once
        for(int i = 0; i < count; i++) {
            int lastIndex = queue.size() - 1;
            queue.add(0, queue.remove(lastIndex));
        }
    }

    private static void moveQueueLeft(int count) {
        // Move left Queue at once
        for(int i = 0; i < count; i++) {
            queue.add(queue.remove(0));
        }
    }

    private static void intiQueue(int N) {
        sumCount = 0;
        queue = new LinkedList<>();
        for(int i = 0; i< N; i++) {
            queue.add(i+1);
        }
    }
}

/*
Input
10 3
1 2 3

Output
0

Input
10 3
2 9 5

Output
8

Input
32 6
27 16 30 11 6 23

Output
59

Input
10 10
1 6 3 2 7 9 8 4 10 5

Output
14
 */