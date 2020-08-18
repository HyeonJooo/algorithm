import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visit;
	static int[][] arr;
	static int[] dx = {0,-1,0,1,1,1,-1,-1};
	static int[] dy = {-1,0,1,0,1,-1,1,-1};
	static int w,h;
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w==0 && h==0)
            	break;
            
            arr = new int[h][w];
            visit = new boolean[h][w];
            
            for(int i = 0 ; i<h; i++) {
            	for(int j = 0 ; j<w; j++) {
            		arr[i][j] = sc.nextInt();
            	}
            }
            int cnt = 0;
            for(int i = 0 ; i<h; i++) {
            	for(int j = 0; j<w; j++) {
            		if(arr[i][j] == 1 && !visit[i][j]) {
            			bfs(i,j);
            			cnt++;
            		}
            	}
            }
            reset();
            System.out.println(cnt);
        }
    }
	
	static void reset() {
		for(int i = 0; i<h; i++) {
			for(int j = 0 ; j<w; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	visit[x][y] = true;
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
        	int qy = queue.peek()[1];
            queue.poll();
                
            for(int j = 0; j<8; j++) {
                int nx = qx + dx[j];
                int ny = qy + dy[j];

                if(nx<0 || ny<0 || nx>=h || ny>=w)//범위 밖이면 건너뜀
                	continue;
                	
                if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
               		continue;
                
                if(arr[nx][ny] == 0)//바다이면 건너뜀
                	continue;
                
                queue.offer(new int[] {nx,ny});
                visit[nx][ny] = true;
            }
    	}
	}
}
