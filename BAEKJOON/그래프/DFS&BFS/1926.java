import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int n,m;
	
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
       	int cnt = 0;
       	int max = -1;
       	for(int i = 0 ; i<n; i++) {
       		for(int j = 0 ; j<m; j++) {
       			if(map[i][j]==1 && !visit[i][j]) {
       				max = Math.max(max,  bfs(i,j));
       				cnt++;
       			}
       		}
       	}
       	if(cnt == 0)
       		max = 0;
       	System.out.println(cnt);
       	System.out.println(max);
    }
    
    static int bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	int tmp = 1;
    	visit[x][y] = true;
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
            	tmp++;
    		}
    	}
    	return tmp;
    }
}
