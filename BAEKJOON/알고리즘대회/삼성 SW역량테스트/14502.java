import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        combination(map, 0,0);
        System.out.println(answer);
    }

    static void bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int j = 0; j<n; j++) {
            for(int k = 0; k<m; k++) {
                if(map[j][k]==2 && !visit[j][k])
                    queue.offer(new int[] {j,k});
            }
        }

        while(!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();
            for(int i = 0; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
                    continue;

                if(map[nx][ny] != 0)
                    continue;

                if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                    continue;

                queue.offer(new int[] {nx,ny});
                visit[nx][ny] = true;
                map[nx][ny] = 2;
            }
        }
        int cnt = 0;
        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                if(map[i][j] == 0)
                    cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }

    static void combination(int[][] arr, int start, int depth) {
        if(depth == 3) {
            int[][] mapTemp = new int[n][m];
            for(int i = 0 ; i<n; i++) {
                for(int j = 0 ; j<m; j++) {
                    mapTemp[i][j] = arr[i][j];
                }
            }
            bfs(mapTemp);
            visit = new boolean[n][m];
            return;
        }

        for(int i = start; i<n*m; i++) {
            int x = i/m;
            int y = i%m;

            if(arr[x][y] == 0) {
                arr[x][y] = 1;
                combination(arr, i+1, depth+1);
                arr[x][y] = 0;
            }
        }
    }
}
