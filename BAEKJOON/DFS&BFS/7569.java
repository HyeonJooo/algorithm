//백준 알고리즘 7569번 : 토마토
import java.io.*;
import java.util.*;
public class Main {
	
	static int[][][] map;
	static boolean[][][] visit;
	static int[] dh = {0,0,0,0,1,-1};
	static int[] dx = {0,-1,0,1,0,0};
	static int[] dy = {-1,0,1,0,0,0};
	static int n,m,h;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
       	n = sc.nextInt();
       	h = sc.nextInt();
       	map = new int[h][n][m];
       	visit = new boolean[h][n][m];
       	for(int k = 0; k<h; k++){
	       	for(int i = 0; i<n; i++) {
	       		for(int j = 0; j<m; j++){
	       			map[k][i][j] = sc.nextInt();
	       		}
	       	}
       	}
       	
       	bfs();	
       	int max = -1;
       	
       	for(int k = 0; k<h; k++) {
	       	for(int i = 0; i<n; i++) {
	       		for(int j = 0; j<m; j++) {
	       			if(map[k][i][j]==0) {
	       				System.out.println(-1);
	       				System.exit(0);
	       			}
	       			else if(max<map[k][i][j])
	       				max = map[k][i][j];
	       			else
	       				continue;
	       			}
	       		}  
       	}System.out.println(max-1);
    }
    
    static void bfs() {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	for(int a = 0; a<h; a++) {
	    	for(int j = 0; j<n; j++) {
	    		for(int k = 0; k<m; k++) {
	    			if(map[a][j][k]==1 && !visit[a][j][k])//익은 토마토이고 방문하지 않은 곳이면 큐에삽입
	    		    	queue.offer(new int[] {a,j,k});    				
	    		}
	    	}
    	}
    	while(!queue.isEmpty()) {
    			int qh = queue.peek()[0];
    			int qx = queue.peek()[1];
    			int qy = queue.peek()[2];
            	queue.poll();
            	
    		for(int i = 0; i<6; i++) {
            	int nh = qh + dh[i];
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nh<0 || nx>=n || ny>=m || nh>=h)//범위 밖에면 건너뜀
            		continue;
            	
            	if(map[nh][nx][ny] != 0)//익지않은 토마토가 아닌 경우 건너뜀
            		continue;
            	
            	if(visit[nh][nx][ny])//이미 방문한 곳이면 건너뜀
            		continue;

            	queue.offer(new int[] {nh,nx,ny});
            	visit[nh][nx][ny] = true;
            	map[nh][nx][ny] = map[qh][qx][qy]+1;
    		}	
    	}	
    }
}
