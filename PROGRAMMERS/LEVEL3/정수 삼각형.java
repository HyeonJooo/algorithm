import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] t = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(t));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        if(triangle.length == 1)
            return triangle[0][0];

        for(int i = 1; i<triangle.length; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if(j == triangle[i].length-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }

            }
        }
        for(int i = 0; i<dp.length; i++) {
            if(answer < dp[dp.length-1][i]) {
                answer = dp[dp.length-1][i];
            }
        }

        return answer;
    }
}
