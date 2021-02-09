import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,m;
    static int ans;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i<T; i++) {
            m = sc.nextInt(); //가로길이
            n = sc.nextInt(); //세로길이
            int k = sc.nextInt(); //배추위치 개수

            map = new int[n][m];
            visit = new boolean[n][m];
            for(int a = 0; a<k; a++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                map[num2][num1] = 1;
            }

            for(int a = 0; a<n; a++) {
                for(int b = 0; b<m; b++) {
                    if(map[a][b] == 1 && !visit[a][b])
                        bfs(a,b);
                }
            }
            System.out.println(ans);
            ans = 0;
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {x,y});

        while(!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();

            for(int i = 0; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
                    continue;

                if(map[nx][ny] == 0)
                    continue;

                if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                    continue;

                queue.offer(new int[] {nx,ny});
                visit[nx][ny] = true;
            }
        }
        ans++;
    }
}
