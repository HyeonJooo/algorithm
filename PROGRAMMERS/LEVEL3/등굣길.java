import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = 100;
        int n = 100;
        int[][] p = {};
//        int[][] p = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};
        System.out.println(solution(m,n,p));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n+1][m+1];
        for(int i = 0; i<puddles.length; i++) {
            arr[puddles[i][1]][puddles[i][0]] = -1;
        }
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;

        for(int i = 1 ; i<dp.length; i++) {
            for(int j = 1; j<dp[i].length; j++) {
                if(i==1 && j==1)
                    continue;

                if(arr[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if(i == 1) {
                    if(arr[i][j] != -1) {
                        dp[i][j] = dp[i][j-1];
                    }
                }

                else if(j == 1) {
                    if(arr[i][j] != -1) {
                        dp[i][j] = dp[i-1][j];
                    }
                }

                else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
        }
        answer = dp[n][m] % 1000000007;
        return answer;
    }
}
