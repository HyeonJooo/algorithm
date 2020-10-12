import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1 ; i<=n; i++) {
        	arr[i] = sc.nextInt();
        	dp[i] = dp[i-1] + arr[i];
        }
        
        for(int a = 0 ; a<m; a++) {
        	int i = sc.nextInt();
        	int j = sc.nextInt();        	
        	System.out.println(dp[j]-dp[i-1]);
        }
   }
}
