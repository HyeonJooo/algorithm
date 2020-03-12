//백준 알고리즘 1463번 : 1로 만들기
import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		if(n==1) {
			System.out.println(0);
			System.exit(0);
		}
		if(n==1 || n==2) {
			System.out.println(1);
			System.exit(0);
		}
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
    	
    	for(int i = 4; i<=n; i++) {
    		if(i%3==0)
    			dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
    		else if(i%2==0)
    			dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
    		else
    			dp[i] = dp[i-1] + 1;
    			
    	}
		System.out.println(dp[n]);
	}
}
