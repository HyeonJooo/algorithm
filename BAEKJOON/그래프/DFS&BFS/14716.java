import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static int n,m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0 ; i<n; i++) {
            for(int j = 0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                if(!visit[i][j] && arr[i][j] == 1) {
                    dfs(i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for(int i = 0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m) {
                if(!visit[nx][ny] && arr[nx][ny]==1)
                    dfs(nx,ny);
            }
        }
    }
}
