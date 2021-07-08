import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] grid = {{8}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for(int i = 1; i<dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1; i<grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i<dp.length; i++) {
            for(int j = 1; j<dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
