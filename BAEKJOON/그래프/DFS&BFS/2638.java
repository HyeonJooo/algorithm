//백준 알고리즘 2638번 : 치즈
import java.io.*;
import java.util.*;
public class Main {
   static int[][] arr;
   static int[][] visit;
   static boolean[][] visit2;
   static int[] dx = {-1,0,0,1};
   static int[] dy = {0,-1,1,0};
   static int n,m;
   public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visit = new int[n][m];
        visit2 = new boolean[n][m];
        for(int i = 0 ; i<n; i++) {
           for(int j = 0; j<m; j++) {
              arr[i][j] = sc.nextInt();
           }
        }
        boolean check = true;
        int cnt = 0;
        while(true) {
            bfs();
            check = true;
            for(int i = 0; i<n; i++) {
            	for(int j = 0; j<m; j++) {
            		if(visit[i][j] >= 2) {
            			arr[i][j] = 0;
            			check = false;
            		}
            	}
            }
            if(check == true)
            	break;
            cnt++;
            for(int i = 0 ; i<n; i++) {
            	for(int j = 0; j<m; j++) {
            		visit[i][j] = 0;
            		visit2[i][j] = false;
            	}
            }
        }
        System.out.println(cnt);
    }
    
    static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {0,0});        		
        visit2[0][0] = true;
        while(!queue.isEmpty()) {
        	int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();
            if(arr[qx][qy] == 1)
            	continue;
            
            for(int i = 0; i<4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m)
                   continue;
                
                if(visit2[nx][ny] == true)
                	continue;
                
                if(arr[nx][ny]==1) {
                    visit[nx][ny]++;
                    continue;
                }
                visit2[nx][ny] = true;
                queue.offer(new int[] {nx,ny});
            }
        }
    }
}
