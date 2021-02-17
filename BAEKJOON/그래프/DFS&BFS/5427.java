import java.io.*;
import java.util.*;
public class Main {
    static String[][] map;
    static boolean[][] visit1;
    static boolean[][] visit2;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,m;
    static int ans = 0;
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
            check = true;
            ans = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            map = new String[n][m];
            visit1 = new boolean[n][m];
            visit2 = new boolean[n][m];
            for(int i = 0; i<n; i++) {
                String s = sc.next();
                map[i] = s.split("");
            }
            bfs(0,0);
            if(check)
                System.out.println(ans+1);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue1 = new LinkedList<int[]>(); //상근이 좌표
        Queue<int[]> queue2 = new LinkedList<int[]>(); //불 좌표
        for(int j = 0; j<n; j++) {
            for(int k = 0; k<m; k++) {
                if(map[j][k].equals("@") && !visit1[j][k]) {
                    queue1.offer(new int[] {j,k});
                    visit1[j][k] = true;
                }
                if(map[j][k].equals("*") && !visit2[j][k]) {
                    queue2.offer(new int[] {j,k});
                    visit2[j][k] = true;
                }
            }
        }

        while(!queue1.isEmpty()) {
            int size = queue2.size();

            for(int a = 0; a<size; a++) {
                int qx = queue2.peek()[0];
                int qy = queue2.peek()[1];
                queue2.poll();

                for(int i = 0; i<4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
                        continue;

                    if(map[nx][ny].equals("#"))
                        continue;

                    if(visit2[nx][ny])//이미 방문한 곳이면 건너뜀
                        continue;

                    queue2.offer(new int[] {nx,ny});
                    visit2[nx][ny] = true;
                    map[nx][ny] = "*";
                }
            }

            int size1 = queue1.size();
            for(int a = 0; a<size1; a++) {
                int qx = queue1.peek()[0];
                int qy = queue1.peek()[1];
                queue1.poll();

                for(int i = 0; i<4; i++) {
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];

                    if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 탈출성공
                        return;

                    if(map[nx][ny].equals("*") || map[nx][ny].equals("#"))
                        continue;

                    if(visit1[nx][ny])//이미 방문한 곳이면 건너뜀
                        continue;

                    queue1.offer(new int[] {nx,ny});
                    visit1[nx][ny] = true;
                }
            }

            if(queue1.size() == 0) {
                System.out.println("IMPOSSIBLE");
                check = false;
                return;
            }
            ans++;
        }
    }
}
