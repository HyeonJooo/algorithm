import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static boolean[][] visit;
    static int[][] arr;
    static int[] dx = {0,1,-1,0,1,-1,1,-1};
    static int[] dy = {1,0,0,-1,1,-1,-1,1};
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];


        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i<n; i++) {
            for(int j = 0 ; j<m; j++) {
                if(arr[i][j] == 0)
                    bfs(i,j);
            }
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        int cnt = 0;
        boolean ch = false;
        visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i<size; i++) {
                int qx = queue.peek()[0];
                int qy = queue.peek()[1];
                queue.poll();

                for(int a = 0; a<8; a++) {
                    int nx = qx + dx[a];
                    int ny = qy + dy[a];

                    if(nx>=0 && ny>=0 && nx<n && ny<m) {
                        if(!visit[nx][ny] && arr[nx][ny] == 0) {
                            visit[nx][ny] = true;
                            queue.add(new int[]{nx,ny});
                        }
                        else if(arr[nx][ny] == 1) {
                            ch = true;
                            break;
                        }
                    }
                }
                if(ch) {
                    answer = Math.max(answer, cnt+1);
                    return;
                }
            }
            cnt++;
        }
    }
}
