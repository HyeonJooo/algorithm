import java.io.*;
import java.util.*; 
public class Main {
    public static int n;
    public static int[][] arr;
    static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
    public static boolean[][] visited;
    public static int k, count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        int max = 0;
        for(int i = 0; i<n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++) {
            	arr[i][j] = Integer.parseInt(str.nextToken());
            	if(max<arr[i][j])
            		max = arr[i][j];
            }
       }
       int numMax = 0;
       for(k = 0; k<=max; k++) {
    	   count = 0;
    	   visitClear();
           for(int i=0; i < n; i++) {
               for(int j=0; j < n; j++) {
            	   if(arr[i][j]>k && !visited[i][j]) {
            		   BFS(i, j);
            		   count++;
            	   }
               }
           }
           if(numMax < count)
        	   numMax = count;
       }       
       System.out.println(numMax);
    }
    
    public static void visitClear() {
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			visited[i][j] = false;
    		}
    	}
    }
    
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
 
        while(!queue.isEmpty()) {
            int currX = queue.peek()[0];
            int currY = queue.peek()[1];
            queue.poll();
            
            for(int i = 0; i<4; i++) {
            	int nx = currX + dx[i];
            	int ny = currY + dy[i];
            	if(nx < 0 || ny < 0 || ny >= n || nx >= n) continue;	 
	            if(arr[nx][ny] <= k) continue;
	            if(visited[nx][ny]) continue;	           
	            visited[nx][ny] = true;
	            queue.offer(new int[] {nx, ny});
	        }
        }
    }
}
