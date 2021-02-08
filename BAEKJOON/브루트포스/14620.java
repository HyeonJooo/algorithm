import java.util.*;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n;
    static int[][] arr;
    static boolean[][] check;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0 ; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        ans = Integer.MAX_VALUE;
        check = new boolean[n][n];
        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int level, int sum) {
        if(level == 3) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = 1; i<n; i++) {
            for(int j = 1; j<n; j++) {
                if(isPossible(i,j)) {
                    int tmpSum = getSum(i,j);
                    dfs(level+1, sum+tmpSum);
                    clearCheck(i,j);
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        for(int i = 0; i<4; i++) {
            int qx = x + dx[i];
            int qy = y + dy[i];

            if(qx < 0 || qy < 0 || qx >= n || qy >= n)
                return false;

            if(check[qx][qy] == true)
                return false;
        }
        return true;
    }

    static int getSum(int x, int y) {
        int sum = 0;
        for(int i = 0; i<4; i++) {
            int qx = x + dx[i];
            int qy = y + dy[i];
            sum += arr[qx][qy];
            check[qx][qy] = true;
        }
        sum += arr[x][y];
        check[x][y] = true;
        return sum;
    }

    static void clearCheck(int x, int y) {
        for(int i = 0 ; i<4; i++) {
            int qx = x + dx[i];
            int qy = y + dy[i];
            check[qx][qy] = false;
        }
        check[x][y] = false;
    }
}
