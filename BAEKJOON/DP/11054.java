import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n][3]; // 0: vaule, 1: length(<), 2: length(>)
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            dp[i][0] = v;
            dp[i][1] = 1; dp[i][2] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j][0] < v)
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                if (dp[j][0] > v) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
                    dp[i][2] = Math.max(dp[i][2], dp[j][1] + 1);
                }
            }
            maxLength = Math.max(maxLength, Math.max(dp[i][1], dp[i][2]));
        }
        System.out.println(maxLength);
    }
}
