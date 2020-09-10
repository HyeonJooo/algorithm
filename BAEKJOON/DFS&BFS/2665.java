import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	static int[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int n;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	n = Integer.parseInt(br.readLine());
       	map = new int[n][n];
       	visit = new int[n][n];
       	for(int i = 0; i<n; i++) {
       		String[] st = br.readLine().split("");
       		for(int j = 0; j<n; j++){
       			map[i][j] = Integer.parseInt(st[j]);
       			visit[i][j] = Integer.MAX_VALUE;
       		}
       	}
       	bfs();
       	
       	System.out.println(visit[n-1][n-1]);
    }
    
    static void bfs() {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {0,0});    				
    	visit[0][0] = 0;
    	
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
    		int qy = queue.peek()[1];
           	queue.poll();
        	for(int i = 0; i<4; i++) {
               	int nx = qx + dx[i];
               	int ny = qy + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n)//범위 밖이면 건너뜀
               		continue;
                	
                if(visit[nx][ny] <= visit[qx][qy])//더 적은 수의 벽을 부섰다면 건너뜀
                	continue;
                
                if(map[nx][ny] == 1) 
                	visit[nx][ny] = visit[qx][qy];
                else
                	visit[nx][ny] = visit[qx][qy] + 1;
                
            	queue.offer(new int[] {nx,ny});  		
          	}
    	}
    }
}
