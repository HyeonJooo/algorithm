import java.io.*;
import java.util.*;
public class Main {
	static char[][] arr;
	static boolean[][] visit;
	static int r,c;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int kcount = 0;
	static int vcount = 0;
	
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visit = new boolean[r][c];
        for(int i = 0; i<r; i++) {
        	arr[i] = br.readLine().toCharArray();
        }
        
        for(int i = 0 ; i<r; i++) {
        	for(int j = 0 ; j<c; j++) {
        		if(arr[i][j]!='#' && !visit[i][j]) {
        			bfs(i,j);
        		}
        	}
        }
        System.out.println(kcount + " " + vcount);
	}
    static void bfs(int x, int y) {
    	int kcnt = 0;
    	int vcnt = 0;
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	visit[x][y] = true;
    	if(arr[x][y] == 'k')
    		kcnt++;
    	else if(arr[x][y] == 'v')
    		vcnt++;

    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
    		int qy = queue.peek()[1];
            queue.poll();
    		for(int i = 0; i<4; i++) {
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nx>=r || ny>=c)//범위 밖이면 건너뜀
            		continue;
            	
            	if(arr[nx][ny] == '#')//울타리인 경우 건너뜀
            		continue;
            	
            	if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
            		continue;

            	queue.offer(new int[] {nx,ny});
            	visit[nx][ny] = true;
            	if(arr[nx][ny] == 'v')
            		vcnt++;
            	if(arr[nx][ny] == 'k')
            		kcnt++;
    		}
    	}
    	if(kcnt > vcnt)
    		kcount += kcnt;
    	else
    		vcount += vcnt;
    }
}
