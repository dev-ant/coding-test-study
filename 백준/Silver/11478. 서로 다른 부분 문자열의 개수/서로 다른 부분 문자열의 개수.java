import java.util.*;
public class Main{
 public static void main(String[] agrs){
 Scanner sc = new Scanner(System.in);
 String str = sc.nextLine();
 char[] arr = str.toCharArray();
 
 int count = 0;
 for(int i=arr.length-1; i>=0; i--){
 for(int j=i; j<arr.length; j++){
 String temp1 = str.substring(i+1);
 String temp2 = str.substring(i, j+1);
 if(temp1.contains(temp2)){
 continue;
 }else{
 count++; 
 }
 }
 }
System.out.println(count);
 }
}
