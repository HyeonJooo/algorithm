//백준 알고리즘 3055번 : 탈출
import java.io.*;
import java.util.*;
public class Main {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int r,c;
	static String[][] arr;
	static boolean[][] watervisit;
	static boolean[][] visit;
	static int cnt = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	r = sc.nextInt();
    	c = sc.nextInt();
    	arr = new String[r][c];
    	watervisit = new boolean[r][c];//물이동 체크
    	visit = new boolean[r][c];//고슴도치 이동 체크
    	for(int i = 0; i<r; i++) {
    		String s = sc.next();
    		arr[i] = s.split("");
    	}
    	bfs();   	
    	System.out.println(cnt);
    }
    
    static void bfs() {
    	Queue<int[]> waterqueue = new LinkedList<int[]>();//물 좌표 담는 큐
    	Queue<int[]> queue = new LinkedList<int[]>(); // 고슴도치 좌표 담는 큐
    	for(int j = 0; j<r; j++) {
    		for(int k = 0; k<c; k++) {
    			if(arr[j][k].equals("*") && !watervisit[j][k])//물이면서 아직 방문안한 곳
    		    	waterqueue.offer(new int[] {j,k});    				
    		}
    	}
    	for(int j = 0; j<r; j++) {
    		for(int k = 0; k<c; k++) {
    			if(arr[j][k].equals("S") && !visit[j][k])//고슴도치면서 아직 방문 안한 곳
    		    	queue.offer(new int[] {j,k});    				
    		}
    	}
    	
    	while(true) {
    		cnt++;
    		int watersize = waterqueue.size();
    		for(int a = 0; a<watersize; a++) {
        		int qx = waterqueue.peek()[0];
        		int qy = waterqueue.peek()[1];
                waterqueue.poll();
        		for(int i = 0; i<4; i++) {
                	int nx = qx + dx[i];
                	int ny = qy + dy[i];

                	if(nx<0 || ny<0 || nx>=r || ny>=c)//범위 밖이면 건너뜀
                		continue;
                	
                	if(arr[nx][ny].equals("D") || arr[nx][ny].equals("X"))//굴이거나 돌이면 건너뜀
                		continue;
                	
                	if(watervisit[nx][ny])//이미 방문한 곳이면 건너뜀
                		continue;

                	waterqueue.offer(new int[] {nx,ny});
                	watervisit[nx][ny] = true;
                	arr[nx][ny] = "*";    			
        		}
    		}
    		if(queue.isEmpty()) {
    			System.out.println("KAKTUS");
    			System.exit(0);
    		}
    		
    		int size = queue.size();
    		for(int a = 0; a<size; a++) {
        		int sx = queue.peek()[0];
        		int sy = queue.peek()[1];
        		queue.poll();
        		for(int i = 0; i<4; i++) {
                	int nx = sx + dx[i];
                	int ny = sy + dy[i];

                	if(nx<0 || ny<0 || nx>=r || ny>=c)//범위 밖이면 건너뜀
                		continue;
                	
                	if(arr[nx][ny].equals("*") || arr[nx][ny].equals("X"))//물이거나 돌이면 건너뜀
                		continue;
                	
                	if(visit[nx][ny])//이미 방문한 곳이면 건너뜀
                		continue;
                	if(arr[nx][ny].equals("D"))
                		return;
                	queue.offer(new int[] {nx,ny});
                	visit[nx][ny] = true;
        		}    			
    		}
    	}	
    }    
}
