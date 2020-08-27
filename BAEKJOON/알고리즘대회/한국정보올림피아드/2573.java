import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	static int[][] tmpmap;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int n,m;
	static int year = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
       	m = sc.nextInt();
       	map = new int[n][m];
       	tmpmap = new int[n][m];
       	visit = new boolean[n][m];
       	for(int i = 0; i<n; i++) {
       		for(int j = 0; j<m; j++){
       			map[i][j] = sc.nextInt();
       		}
       	}
       	
       	while(true) {
       		year++;
       		bfs();
       		int check = 0;
       		int count = 0;
           	for(int i = 1 ; i<n-1; i++) {
           		for(int j = 1 ; j<m-1; j++) {
           			if(map[i][j] != 0)
           				check = 1;
           			if(map[i][j] != 0 && !visit[i][j]) {
           				count++;
           				if(count == 2) {
           					System.out.println(year);
           					System.exit(0);
           				}
           				bfs2(i,j);           				
           			}
           		}
           	}
           	if(check == 0) {
           		System.out.println(0);
           		System.exit(0);
           	}
           	for(int i = 0 ; i<n; i++) {
           		for(int j = 0 ; j<m; j++) {
           			visit[i][j] = false;
           		}
           	}
       	}
       	
    }
    
    static void bfs() {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	for(int i = 1; i<n-1; i++) {
    		for(int j = 1; j<m-1; j++) {
    			if(map[i][j]!=0 && !visit[i][j])
    		    	queue.offer(new int[] {i,j});
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
    		int qy = queue.peek()[1];
            queue.poll();
			int cnt = 0;
    		for(int i = 0; i<4; i++) {
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
            		continue;
            	
            	if(map[nx][ny] != 0)//빙산이면 건너뜀. 바다인곳만 세어야돼
            		continue;
            	
            	cnt++;
    		}
    		if(map[qx][qy] - cnt >= 0)
    			tmpmap[qx][qy] = map[qx][qy] - cnt;
    		else
    			tmpmap[qx][qy] = 0;
    	}
    	for(int i = 0 ; i<n; i++) {
    		for(int j = 0 ; j<m; j++) {
    			map[i][j] = tmpmap[i][j];
    			tmpmap[i][j] = 0;
    		}
    	}
    }
    
    static void bfs2(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
    		int qy = queue.peek()[1];
            queue.poll();
			int cnt = 0;
    		for(int i = 0; i<4; i++) {
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nx>=n || ny>=m)//범위 밖이면 건너뜀
            		continue;
            	
            	if(map[nx][ny] == 0)//바다이면 건너뜀
            		continue;
            	
            	if(visit[nx][ny])
            		continue;
            	
            	visit[nx][ny] = true;
            	queue.offer(new int[] {nx,ny});
    		}

    	}
    }
}
