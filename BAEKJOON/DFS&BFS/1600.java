import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	static boolean[][][] visit;
	static int k,w,h;
	static int[] dx1 = {-1,-2,-2,-1,1,2,1,2};
	static int[] dy1 = {-2,-1,1,2,-2,-1,2,1};
	static int[] dx2 = {1,0,-1,0};
	static int[] dy2 = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        
        arr = new int[h][w];
        visit = new boolean[h][w][k+1];
        for(int i = 0 ; i<h; i++) {
        	for(int j = 0 ; j<w; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        System.out.println(bfs());
        
    }
    static int bfs() {
    	int ans = 0;
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[]{0,0,k});
    	visit[0][0][k] = true;
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int a = 0 ; a<size; a++) {
    			int qx = queue.peek()[0];
    			int qy = queue.peek()[1];
    			int horse = queue.peek()[2];
    			queue.poll();
    			if(qx==h-1 && qy==w-1)
    				return ans;
    			
        		for(int i = 0; i<4; i++) {
                	int nx2 = qx + dx2[i];
                	int ny2 = qy + dy2[i];
                	
                	if(nx2==h-1 && ny2==w-1)
        				return ans+1;
                	
                	if(nx2<0 || ny2<0 || nx2>=h || ny2>=w)//범위 밖이면 건너뜀
                		continue;
                	
                	if(arr[nx2][ny2] == 1)
                		continue;
                	
                	if(visit[nx2][ny2][horse])//이미 방문한 곳이면 건너뜀
                		continue;

                	queue.offer(new int[] {nx2,ny2,horse});
                	visit[nx2][ny2][horse] = true;
            	}
    			
        		if(horse > 0) {
        			for(int i = 0; i<8; i++) {
        				int nx1 = qx + dx1[i];
        				int ny1 = qy + dy1[i];
        				if(nx1==h-1 && ny1==w-1)
        					return ans+1;
        				
        				if(nx1<0 || ny1<0 || nx1>=h || ny1>=w)
        					continue;
        				
        				if(arr[nx1][ny1] == 1)
        					continue;
        				
        				if(visit[nx1][ny1][horse-1])
        					continue;
        				
        				queue.offer(new int[] {nx1,ny1,horse-1});
        				visit[nx1][ny1][horse-1] = true;
        			}
        		}
        	}    
			ans++;
    	}
    	return -1;
    }
}
