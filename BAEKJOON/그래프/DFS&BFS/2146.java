import java.io.*;
import java.util.*;
public class Main {
   static int n;
   static int[][] arr;
   static boolean[][] visit;
   static int[] dx = {0,-1,0,1};
   static int[] dy = {-1,0,1,0};
   static int cnt = -1;
   static int num = 0;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       arr = new int[n+1][n+1];
       visit = new boolean[n+1][n+1];
       for(int i = 1 ; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
               arr[i][j] = sc.nextInt();
            }
       }
       for(int i = 1; i<=n; i++) {//섬 구역별로 번호 붙이기
    	   for(int j = 1; j<=n; j++) {
    		   if(arr[i][j]==1 && !visit[i][j]) {
    			   bfsNumber(i,j);
    		   }
    	   }
       }
       reset();
       cnt = -1;
         
       int min = n*n;
       for(int i = 1; i<num; i++) {
    	   min = Math.min(min, bfs(cnt));
    	   reset();
    	   cnt--;
       }
       System.out.println(min);
   }
    
    static void reset() {//visit배열 초기화
    	for(int i = 1; i<=n; i++) {
    		for(int j = 1; j<=n; j++) {
    			visit[i][j] = false;
    		}
    	}
    }
    
    static void bfsNumber(int x, int y) {//섬 번호 붙이기
       arr[x][y] = cnt;
       Queue<int[]> queue = new LinkedList<int[]>();
       queue.offer(new int[] {x,y});
       
       while(!queue.isEmpty()) {
             int qx = queue.peek()[0];
             int qy = queue.peek()[1];
             queue.poll();
             for(int i = 0; i<4; i++) {
               int nx = qx + dx[i];
               int ny = qy + dy[i];

               if(nx<=0 || ny<=0 || nx>n || ny>n)//범위 밖이면 건너뜀
                  continue;
               
               if(arr[nx][ny] == 0)
                  continue;
               
               if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                  continue;

               queue.offer(new int[] {nx,ny});
               visit[nx][ny] = true;
               arr[nx][ny] = cnt;
          }
       }
       cnt--;
       num++;
    }   
    
    static int bfs(int cnt) {
    	int ans = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 1; i<=n; i++) {
        	for(int j = 1; j<=n; j++) {
        		if(arr[i][j] == cnt)
        			queue.offer(new int[] {i,j});
        	}
        }
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i = 0; i<size; i++) {
            	int qx = queue.peek()[0];
            	int qy = queue.peek()[1];
    	        queue.poll();
    	        for(int j = 0; j<4; j++) {
	            	int nx = qx + dx[j];
	                int ny = qy + dy[j];
	                if(nx>0 && nx<=n && ny>0 && ny<=n) {
	                	if(arr[nx][ny] !=0 && arr[nx][ny]!=cnt) {
	                		return ans;
	                	}
	                	else if(arr[nx][ny]==0 && !visit[nx][ny]) {
	                		visit[nx][ny] = true;
	                		queue.offer(new int[] {nx,ny});
	                	}
	                }
    	        }
        	}
        	ans++;
        }
        return ans;
   }
}
