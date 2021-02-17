import java.io.*;
import java.util.*;
public class Main {
	static char[][] originmap;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1,-1,-1,1,1};
	static int[] dy = {-1,0,1,0,-1,1,-1,1};
	static int h,w;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
       	w = Integer.parseInt(st.nextToken());
       	originmap = new char[h][w];
       	int [][]map = new int[h][w];
       	visit = new boolean[h][w];
       	for(int i = 0; i<h; i++) {
       		String s = br.readLine();
       		originmap[i] = s.toCharArray();
       	}
       	
       	for(int i = 0 ; i<h; i++) {
       		for(int j = 0 ; j<w; j++) {
       			if(originmap[i][j] == '.') {
       				map[i][j] = 0;
       				visit[i][j] = true;
       			}

       			else
       				map[i][j] = originmap[i][j] - '0';
       		}
       	}
       	System.out.println(bfs(map)-1);
       
    }
    
    static int bfs(int[][] map) {
    	int[][] count = new int[h][w];
    	int answer = 0;
    	Queue<int[]> queue = new LinkedList<int[]>();
    	Queue<int[]> queue2 = new LinkedList<int[]>();
    	for(int i = 0; i<h; i++) {
    		for(int j = 0; j<w; j++) {
    			if(map[i][j]==0)
    		    	queue.offer(new int[] {i,j});    				
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		
    		for(int a = 0; a<size; a++) {
        		int qx = queue.peek()[0];
        		int qy = queue.peek()[1];
               	queue.poll();
               	
        		for(int i = 0; i<8; i++) {
                	int nx = qx + dx[i];
                	int ny = qy + dy[i];

                	if(nx<0 || ny<0 || nx>=h || ny>=w)//범위 밖이면 건너뜀
                		continue;
                	
                	if(visit[nx][ny])
                		continue;
                	
                	if(map[nx][ny] != 0) {
                		count[nx][ny]++;
                		
                		if(count[nx][ny] >= map[nx][ny]) {
                			visit[nx][ny] = true;
            		    	queue2.offer(new int[] {nx,ny});
                		}
                	}
        		}
    		}
    		while(!queue2.isEmpty()) {
        		int qx1 = queue2.peek()[0];
        		int qy1 = queue2.peek()[1];
        		queue2.poll();
        		queue.offer(new int[] {qx1,qy1});

    		}
    		answer++;
    	}
    	return answer;
    }
}
