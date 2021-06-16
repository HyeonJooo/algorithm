import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static List<List<Integer>> list;
    static int[][] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        score = new int[n+1];

        for(int i = 1; i<=n; i++) {
            score[i] = sc.nextInt();
        }

        list = new ArrayList<>();
        for(int i = 1; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i <n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dp = new int[n+1][2];
        visit = new boolean[n+1];
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int u) {
        if(visit[u])
            return;

        visit[u] = true;
        dp[u][0] = 0;
        dp[u][1] = score[u];

        for(int i = 0; i<list.get(u).size(); i++) {
            if(!visit[list.get(u).get(i)]) {
                dfs(list.get(u).get(i));
                dp[u][0] = dp[u][0] + Math.max(dp[list.get(u).get(i)][0], dp[list.get(u).get(i)][1]);
                dp[u][1] = dp[u][1] + dp[list.get(u).get(i)][0];
            }
        }
    }
}
