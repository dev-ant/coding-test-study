import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, m, sum;
        h = sc.nextInt();
        m = sc.nextInt();
        sum = h*60 + m - 45;
        if(sum<0) {
        	sum = 24*60 + sum;
        }
        h = sum/60;
        m = sum%60;
        System.out.println(h+" "+m);
        sc.close();
    }
}