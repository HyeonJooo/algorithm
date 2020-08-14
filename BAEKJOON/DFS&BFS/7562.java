import java.io.*;
import java.util.*;
public class Main {
	static int l;
	static boolean[][] visit;
	static int[] dx = {1,2,2,1,-1,-2,-2,-1};
	static int[] dy = {2,1,-1,-2,-2,-1,1,2};
	static int startX,startY;
	static int endX,endY;
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i<t; i++) {
        	l = sc.nextInt();
        	startX = sc.nextInt();
        	startY = sc.nextInt();
        	endX = sc.nextInt();
        	endY = sc.nextInt();
        	visit = new boolean[l][l];
        	if(startX==endX && startY==endY)
        		System.out.println(0);
        	else
        		System.out.println(bfs(startX, startY));
        	reset();
        }
    }
	
	static void reset() {
		for(int i = 0; i<l; i++) {
			for(int j = 0 ; j<l; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	static int bfs(int x, int y) {
		int answer = 0;
		int finish = 0;
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	visit[x][y] = true;
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int i = 0 ; i<size; i++) {
        		int qx = queue.peek()[0];
        		int qy = queue.peek()[1];
                queue.poll();
        		for(int j = 0; j<8; j++) {
                	int nx = qx + dx[j];
                	int ny = qy + dy[j];

                	if(nx==endX && ny==endY) {
                		finish = 1;
                		break;
                	}
                	if(nx<0 || ny<0 || nx>=l || ny>=l)//범위 밖이면 건너뜀
                		continue;
                	
                	if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                		continue;
                	
                	queue.offer(new int[] {nx,ny});
                	visit[nx][ny] = true;
        		}    			
    		}
    		answer++;
    		if(finish == 1)
    			break;
    	}		
    	return answer;
	}
}
