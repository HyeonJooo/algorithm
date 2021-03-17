import java.io.*;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m][2]; //[x][y][벽을부섰는가?]
        for(int i = 0; i<n; i++) {
            String s = sc.next();
            String[] st;
            st = s.split("");
            for(int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(0,0,0,1)); //0,0에서 시작
        visit[0][0][0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int qx = node.x;
            int qy = node.y;
            int wall = node.wall;
            int count = node.count;

            if(qx == n-1 && qy == m-1) {
                System.out.println(node.count);
                return;
            }

            for(int i = 0; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
                    continue;

                //벽이 아닌경우
                if(map[nx][ny] == 0) {
                    if(!visit[nx][ny][wall]) {
                        queue.add(new Node(nx,ny,wall,count+1));
                        visit[nx][ny][wall] = true;
                    }
                }

                //벽인경우
                else {
                    if(!visit[nx][ny][1] && wall==0) {
                        queue.offer(new Node(nx,ny,1,count+1));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int x;
        int y;
        int wall;
        int count;

        public Node(int x, int y, int wall, int count) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }
}
