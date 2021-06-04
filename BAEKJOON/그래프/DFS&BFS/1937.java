import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i = 0 ; i<n; i++) {
            for(int j = 0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int answer = -1;
        for(int i = 0; i<n; i++) {
            for(int j = 0 ; j<n; j++) {
                answer = Math.max(answer,dfs(i,j));
            }
        }
        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if(dp[x][y] != 0) //dp에 값 있으면 그 값 반환
            return dp[x][y];

        dp[x][y] = 1; //dp에 값이 없으면, 1로 초기화. 1년살수있음.

        for(int i = 0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length &&
                    arr[nx][ny] > arr[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1); //현재위치는 상하좌우에서 최대값+1년
                dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
