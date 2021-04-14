import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] check;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	check = new boolean[301][301];
    	dp = new int[301][301];
    	
    	for(int i = 0; i<=300; i++) {
    		for(int j = 0; j<=300; j++) {
    			dp[i][j] = -1;
    		}
    	}
    	
    	for(int i = 0 ; i<n; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		check[x][y] = true;
    	}
    	System.out.println(find(0,0,m));
    }
    
    static int find(int x, int y, int m) {
    	if(x==301 || y==301) return 0;
    	if(m ==0) return 0;
    	if(dp[x][y] != -1) return dp[x][y];
    	
    	if(check[x][y] == true)
    		dp[x][y] = m;
    	else
    		dp[x][y] = 0;
    	dp[x][y] += Math.max(find(x+1, y, m-1), find(x,y+1, m-1));
    	return dp[x][y];
     }
}
