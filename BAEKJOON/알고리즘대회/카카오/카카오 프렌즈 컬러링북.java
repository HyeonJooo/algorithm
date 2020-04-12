//2017 카카오 코드 페스티벌 예선
import java.util.*;
class Solution {
    static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] visit;
	static int numberOfArea;
	static int maxSizeOfOneArea;
    
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
    	visit = new boolean[m][n];
        bfs(m,n,picture);
    	answer[0] = numberOfArea;
    	answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void bfs(int m, int n, int[][] picture) {
    	int temparea = 0;
    	numberOfArea = 0;
    	maxSizeOfOneArea = Integer.MIN_VALUE;
    	Queue<int[]> queue = new LinkedList<int[]>();
       	for(int i = 0; i<m; i++) {
       		for(int j = 0; j<n; j++) {
        		if(picture[i][j]!=0 && !visit[i][j]) {
        	    	queue.offer(new int[] {i,j});
        		   	numberOfArea++;
        		   	temparea = 0;
        		    	
			       	while(!queue.isEmpty()) {
			       		int qx = queue.peek()[0];
			       		int qy = queue.peek()[1];
			       		queue.poll();
			       		for(int a = 0; a<4; a++) {
			               	int nx = qx + dx[a];
			               	int ny = qy + dy[a];
			
			               	if(nx<0 || ny<0 || nx>=m || ny>=n)//범위 밖이면 건너뜀
			               		continue;
			                	
			               	if(picture[nx][ny] == 0 || picture[nx][ny] != picture[i][j])
			               		continue;
			                	
			               	if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
			               		continue;
		
			               	queue.offer(new int[] {nx,ny});
			               	temparea++;
			               	visit[nx][ny] = true;
			       		}
			       	}
			       	if(maxSizeOfOneArea < temparea)
			       		maxSizeOfOneArea = temparea;
        		}
        	}
    	}
    }
}
