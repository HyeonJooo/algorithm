//백준 알고리즘 2178번 : 미로 탐색
import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int n,m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = sc.nextInt();
       	m = sc.nextInt();
       	map = new int[n][m];
       	visit = new boolean[n][m];
       	for(int i = 0; i<n; i++) {
       		String s = sc.next();
       		for(int j = 0; j<m; j++){
       			map[i][j] = s.charAt(j) - '0';
       		}
       	}
       	bfs(0,0);
       	System.out.println(map[n-1][m-1]);
       	
    }
    
    static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	
    	while(!queue.isEmpty()) {
    			int qx = queue.peek()[0];
    			int qy = queue.peek()[1];
            	queue.poll();
    		for(int i = 0; i<4; i++) {
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nx>=n || ny>=m)
            		continue;
            	
            	if(map[nx][ny] == 0)
            		continue;
            	
            	if(visit[nx][ny])
            		continue;

            	queue.offer(new int[] {nx,ny});
            	visit[nx][ny] = true;
            	map[nx][ny] = map[qx][qy]+1;
    		}
    	}	
    }
}
