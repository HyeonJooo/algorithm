//백준 알고리즘 7576번 : 토마토
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
        m = sc.nextInt();
       	n = sc.nextInt();
       	map = new int[n][m];
       	visit = new boolean[n][m];
       	for(int i = 0; i<n; i++) {
       		for(int j = 0; j<m; j++){
       			map[i][j] = sc.nextInt();
       		}
       	}
       	
       	bfs(0,0);	
       	int max = -1;
       	for(int i = 0; i<n; i++) {
       		for(int j = 0; j<m; j++) {
       			if(map[i][j]==0) {
       				System.out.println(-1);
       				System.exit(0);
       			}
       			else if(max<map[i][j])
       				max = map[i][j];
       			else
       				continue;
       			}
       		}
       	System.out.println(max-1);
    }
    
    static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	for(int j = 0; j<n; j++) {
    		for(int k = 0; k<m; k++) {
    			if(map[j][k]==1 && !visit[j][k])//익은 토마토이고 방문하지 않은 곳이면 큐에삽입
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
            	
            	if(map[nx][ny] != 0)//익지않은 토마토가 아닌경우 건너뜀
            		continue;
            	
            	if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
            		continue;

            	queue.offer(new int[] {nx,ny});
            	visit[nx][ny] = true;
            	map[nx][ny] = map[qx][qy]+1;
    		}
    	}	
    }
}
