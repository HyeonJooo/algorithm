import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static List<List<Integer>> list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트리 정점 수
        int r = sc.nextInt(); // 루트 번호
        int q = sc.nextInt(); // 쿼리 수

        list = new ArrayList<>();
        for(int i = 1; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dp = new int[n+1];
        visit = new boolean[n+1];
        for(int i = 1; i<=n; i++) {
            dp[i] = 1;
        }

        dfs(r);

        for(int i = 0 ; i<q; i++) {
            int u = sc.nextInt();
            System.out.println(dp[u]);
        }
    }

    static int dfs(int u) {
        if(visit[u])
            return dp[u];

        visit[u] = true;
        for(int i = 0; i<list.get(u).size(); i++) {
            if(!visit[list.get(u).get(i)]) {
                dp[u] = dp[u] + dfs(list.get(u).get(i));
            }
        }
        return dp[u];
    }
}
