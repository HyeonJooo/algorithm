import java.io.*;
import java.util.*;
public class Main {
	static int[][] board;
	static boolean[][][] visit;
	static int n;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for(int i = 0 ; i<n; i++) {
        	for(int j = 0 ; j<n; j++) {
        		board[i][j] = sc.nextInt();
        	}
        }
        visit = new boolean[2][n][n];
        System.out.println(bfs());
        
    }
    static int bfs() {
    	int ans = 0;
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[]{0,0,0,1});
    	visit[0][0][0] = true;
    	visit[0][0][1] = true;
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int a = 0 ; a<size; a++) {
    			int qx1 = queue.peek()[0];
    			int qy1 = queue.peek()[1];
    			int qx2 = queue.peek()[2];
    			int qy2 = queue.peek()[3];
    			queue.poll();
    			
    			if((qx1==n-1&&qy1==n-1) ||(qx2==n-1&&qy2==n-1))
    				return ans;
    			
    			if(qx1==qx2) {//가로로 놓여져있는 경우
    				for(int i = 0 ; i<4; i++) {//상하좌우 이동
    					if(i==0) {//오른쪽이동
        					int nx = qx2 + dx[i];
        					int ny = qy2 + dy[i];
        					if(nx<0 || ny<0 || nx>=n || ny>=n)
        						continue;
        					if(board[nx][ny]==1)
        						continue;
        					if(visit[0][nx][ny])
        						continue;
        					
                        	queue.offer(new int[] {qx2,qy2,nx,ny});
                        	visit[0][nx][ny] = true;    					        					
    					}
    					
    					else if(i==1) {//왼쪽이동
    						int nx = qx1 + dx[i];
    						int ny = qy1 + dy[i];
    						if(nx<0 || ny<0 || nx>=n || ny>=n)
        						continue;
        					if(board[nx][ny]==1)
        						continue;
        					if(visit[0][nx][ny])
        						continue;
        					
                        	queue.offer(new int[] {nx,ny,qx1,qy1});
                        	visit[0][nx][ny] = true;
    					}
    					
    					else {
    						int nx1 = qx1 + dx[i];
    						int ny1 = qy1 + dy[i];
    						int nx2 = qx2 + dx[i];
    						int ny2 = qy2 + dy[i];
    						if(nx1<0 || ny1<0 || nx2<0 || ny2<0 || nx1>=n || ny1>=n || nx2>=n || ny2>=n)
    							continue;
    						if(board[nx1][ny1]==1 || board[nx2][ny2]==1)
    							continue;
    						if(visit[0][nx1][ny1] && visit[0][nx2][ny2])
    							continue;
    						
    						queue.offer(new int[] {nx1,ny1,nx2,ny2});
    						visit[0][nx1][ny1] = true;
    						visit[0][nx2][ny2] = true;
    					}
    				}
    				//세로로 회전
    				//아래방향으로 회전
    				int nx1 = qx1 + 1;
    				int nx2 = qx2 + 1;
    				int ny1 = qy1;
    				int ny2 = qy2;
    				if(nx1>=0&&ny1>=0&&nx2>=0&&ny2>=0&&nx1<n&&ny1<n&&nx2<n&&ny2<n) {
    					if(board[nx1][ny1]==0 && board[nx2][ny2]==0) {
    						if((!visit[1][nx1][ny1] && !visit[1][qx1][qy1])) {
    		    				queue.offer(new int[] {qx1,qy1,nx1,ny1});
    		    				visit[1][nx1][ny1] = true;
    		    				visit[1][qx1][qy1] = true;
    						}
    						if((!visit[1][nx2][ny2] && !visit[1][qx2][qy2])) {
    		    				queue.offer(new int[] {qx2,qy2,nx2,ny2});
    		    				visit[1][nx2][ny2] = true;
    		    				visit[1][qx2][qy2] = true;
    						}
    					}
    				}
    				//윗방향으로 회전
    				nx1 = qx1 - 1;
    				nx2 = qx2 - 1;
    				ny1 = qy1;
    				ny2 = qy2;
    				if(nx1>=0&&ny1>=0&&nx2>=0&&ny2>=0&&nx1<n&&ny1<n&&nx2<n&&ny2<n) {
    					if(board[nx1][ny1]==0 && board[nx2][ny2]==0) {
    						if((!visit[1][nx1][ny1] && !visit[1][qx1][qy1])) {
    		    				queue.offer(new int[] {nx1,ny1,qx1,qy1});
    		    				visit[1][nx1][ny1] = true;
    		    				visit[1][qx1][qy1] = true;
    						}
    						if((!visit[1][nx2][ny2] && !visit[1][qx2][qy2])) {
    		    				queue.offer(new int[] {nx2,ny2,qx2,qy2});
    		    				visit[1][nx2][ny2] = true;
    		    				visit[1][qx2][qy2] = true;
    						}    						
    					}
    				}   				
    			}
    			
    			else {//세로로 놓여져 있는 경우
    				for(int i = 0 ; i<4; i++) {
    					if(i==2) {//위로이동
        					int nx = qx1 + dx[i];
        					int ny = qy1 + dy[i];
        					if(nx<0 || ny<0 || nx>=n || ny>=n)
        						continue;
        					if(board[nx][ny]==1)
        						continue;
        					if(visit[1][nx][ny])
        						continue;
        					
                        	queue.offer(new int[] {nx,ny,qx1,qy1});
                        	visit[1][nx][ny] = true;    					        					
    					}
    					
    					else if(i==3) {//아래로이동
    						int nx = qx2 + dx[i];
    						int ny = qy2 + dy[i];
    						if(nx<0 || ny<0 || nx>=n || ny>=n)
        						continue;
        					if(board[nx][ny]==1)
        						continue;
        					if(visit[1][nx][ny])
        						continue;
        					
                        	queue.offer(new int[] {qx2,qy2,nx,ny});
                        	visit[1][nx][ny] = true;
    					}
    					
    					else {
    						int nx1 = qx1 + dx[i];
    						int ny1 = qy1 + dy[i];
    						int nx2 = qx2 + dx[i];
    						int ny2 = qy2 + dy[i];
    						if(nx1<0 || ny1<0 || nx2<0 || ny2<0 || nx1>=n || ny1>=n || nx2>=n || ny2>=n)
    							continue;
    						if(board[nx1][ny1]==1 || board[nx2][ny2]==1)
    							continue;
    						if(visit[1][nx1][ny1] && visit[1][nx2][ny2])
    							continue;
    						
    						queue.offer(new int[] {nx1,ny1,nx2,ny2});
    						visit[1][nx1][ny1] = true;
    						visit[1][nx2][ny2] = true;
    					}
    				}
    				//가로로 회전
    				int nx1 = qx1;
    				int nx2 = qx2;
    				int ny1 = qy1+1;
    				int ny2 = qy2+1;
    				if(nx1>=0&&ny1>=0&&nx2>=0&&ny2>=0&&nx1<n&&ny1<n&&nx2<n&&ny2<n) {
    					if(board[nx1][ny1]==0 && board[nx2][ny2]==0) {
    						if((!visit[0][nx1][ny1] && !visit[0][qx1][qy1])) {
    		    				queue.offer(new int[] {qx1,qy1,nx1,ny1});
    		    				visit[0][nx1][ny1] = true;
    		    				visit[0][qx1][qy1] = true;
    						}
    						if((!visit[0][nx2][ny2] && !visit[0][qx2][qy2])) {
    		    				queue.offer(new int[] {qx2,qy2,nx2,ny2});
    		    				visit[0][nx2][ny2] = true;
    		    				visit[0][qx2][qy2] = true;
    						}    						
    					}
    				}
    				
    				nx1 = qx1;
    				nx2 = qx2;
    				ny1 = qy1-1;
    				ny2 = qy2-1;
    				if(nx1>=0&&ny1>=0&&nx2>=0&&ny2>=0&&nx1<n&&ny1<n&&nx2<n&&ny2<n) {
    					if(board[nx1][ny1]==0 && board[nx2][ny2]==0) {
    						if((!visit[0][nx1][ny1] && !visit[0][qx1][qy1])) {
    		    				queue.offer(new int[] {nx1,ny1,qx1,qy1});
    		    				visit[0][nx1][ny1] = true;
    		    				visit[0][qx1][qy1] = true;
    						}
    						if((!visit[0][nx2][ny2] && !visit[0][qx2][qy2])) {
    		    				queue.offer(new int[] {nx2,ny2,qx2,qy2});
    		    				visit[0][nx2][ny2] = true;
    		    				visit[0][qx2][qy2] = true;
    						}    						
    					}
    				}   				
    			}
         	}    
			ans++;
    	}
    	return ans;
    }
}
