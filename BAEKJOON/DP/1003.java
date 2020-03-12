//백준 알고리즘 1003번 : 피보나치 함수
import java.io.*;
import java.util.*;
public class Main {
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        dp = new int[41][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for(int i = 2; i<41; i++) {
        	dp[i][0] = dp[i-1][0] + dp[i-2][0];
        	dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        for(int i = 0; i<t; i++) {
        	int n = sc.nextInt();
        	System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
