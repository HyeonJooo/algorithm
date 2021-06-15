import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        arr = new String[n][m];
        visit = new boolean[n][m];

        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                arr[i][j] = ".";
            }
        }
        for(int i = 0; i<k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r-1][c-1] = "#";
        }

        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                if(!visit[i][j] && arr[i][j].equals("#"))
                    bfs(i,j);
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();

            for(int i = 0 ; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(!visit[nx][ny] && arr[nx][ny].equals("#")) {
                        cnt++;
                        queue.add(new int[]{nx,ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        answer = Math.max(answer, cnt);
    }
}
