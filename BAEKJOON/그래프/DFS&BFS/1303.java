import java.io.*;
import java.util.*;

public class Main {

    static String[][] arr;
    static boolean[][] visit;
    static int white, black;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[m][n];
        visit = new boolean[m][n];

        for(int i = 0; i<m; i++) {
            String s = br.readLine();
            arr[i] = s.split("");
        }

        for(int i = 0 ; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(arr[i][j].equals("W") && !visit[i][j])
                    bfs1(i,j);
            }
        }
        visit = new boolean[m][n];

        for(int i = 0 ; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(arr[i][j].equals("B") && !visit[i][j])
                    bfs2(i,j);
            }
        }

        System.out.println(white + " " + black);
    }

    static void bfs1(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();

            for(int i = 0 ; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx >=0 && ny >=0 && nx < m && ny <n) {
                    if(!visit[nx][ny] && arr[nx][ny].equals("W")) {
                        cnt++;
                        queue.add(new int[]{nx,ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        white += cnt*cnt;
    }

    static void bfs2(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();

            for(int i = 0 ; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx >=0 && ny >=0 && nx < m && ny <n) {
                    if(!visit[nx][ny] && arr[nx][ny].equals("B")) {
                        cnt++;
                        queue.add(new int[]{nx,ny});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        black += cnt*cnt;
    }
}
