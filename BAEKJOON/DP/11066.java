import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
            int k = sc.nextInt();
            int[] arr = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            for(int i = 1; i<=k; i++) {
                arr[i] = sc.nextInt();
                sum[i] = sum[i-1] + arr[i];
            }

            for(int i = 1; i<k; i++) {
                for(int tx = 1; tx+i<=k; tx++) {
                    int ty = tx + i;
                    dp[tx][ty] = Integer.MAX_VALUE;

                    for(int mid = tx; mid<ty; mid++) {
                        dp[tx][ty] = Math.min(dp[tx][ty],
                                dp[tx][mid] + dp[mid+1][ty] + sum[ty]-sum[tx-1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }
    }
}
