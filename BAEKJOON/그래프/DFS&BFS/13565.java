import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            String s = sc.next();
            String[] st = s.split("");
            for(int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 0; i<m; i++) {
            if(!visit[0][i]) {
                dfs(arr,0,i);
                visit = new boolean[n][m];
            }
        }
        System.out.println("NO");
    }

    static void dfs(int[][] arr, int x, int y) {
        visit[x][y] = true;

        for(int i = 0 ; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == arr.length-1 && arr[nx][ny] == 0) {
                System.out.println("YES");
                System.exit(0);
            }

            if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                if(!visit[nx][ny] && arr[nx][ny] == 0) {
                    dfs(arr, nx, ny);
                }
            }
        }
    }
}
