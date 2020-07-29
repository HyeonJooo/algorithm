import java.util.*;
import java.io.*;
public class Main{
   public static void main(String args[]) throws Exception {
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int[] arr = new int[n+1];
	   arr[1] = 1;
	   for(int i = 2; i<=n; i++) {
		   arr[i] = i;
		   for(int j = 1; j*j<=i; j++) {
			   arr[i] = Math.min(arr[i],  arr[i-j*j]+1);
		   }
	   }
	   System.out.println(arr[n]);
   }
}
