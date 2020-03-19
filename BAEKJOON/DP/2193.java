//백준 알고리즘 2193번 : 이친수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	long[] dp = new long[91];
    	if(n==1 || n==2) {
    		System.out.println(1);
    		System.exit(0);
    	}
    	if(n==3) {
    		System.out.println(2);
    		System.exit(0);
    	}
    	dp[1] = 1;
    	dp[2] = 1;
    	dp[3] = 2;
    	
    	for(int i = 4; i<=n; i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	System.out.println(dp[n]);
    }
}
