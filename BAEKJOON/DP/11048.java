import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][m+1];
        long[][] dp = new long[n+1][m+1];
        for(int i = 1; i<=n; i++) {
        	for(int j = 1; j<=m; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }

    	for(int i = 1; i<=n; i++) {
    		for(int j = 1; j<=m; j++) {
    			if(i==1 && j==1)
    				dp[1][1] = arr[1][1];    				
    			
    			else if(i==1) 
    				dp[i][j] = dp[i][j-1] + arr[i][j];
    			
    			else if(j==1) 
    				dp[i][j] = dp[i-1][j] + arr[i][j];
    			
    			else
    				dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + arr[i][j];
    		}
    	}
    	System.out.println(dp[n][m]);	
    }
}
