//백준 알고리즘 16236번 : 아기상어
import java.io.*;
import java.util.*;
public class Main {
	static int[][] map;
	static int[][] visit;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int n;
	static int d = 0;
	static int size = 2, time = 0;
	static int idx1 = 0, idx2 = 0;
	static int minx = 0, miny = 0, mind = 0;
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       	n = sc.nextInt();
       	map = new int[n][n];
       	visit = new int[n][n];
       	for(int i = 0; i<n; i++) {
       		for(int j = 0; j<n; j++){
       			map[i][j] = sc.nextInt();
       		}
       	}
       	int cnt = 0;
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j<n; j++) {
    			if(map[i][j]==9) {
    				idx1 = i;
    				idx2 = j;
    				map[i][j] = 0;
    				break;
    			}
    		}
    	}
    	while(true) {
    		for(int i = 0 ; i<n; i++) {
    			for(int j = 0 ; j<n; j++) {
    				visit[i][j] = -1;
    			}
    		}
    		mind = 401;
    		minx = 21;
    		miny = 21;
           	bfs(idx1, idx2);
           	if(minx != 21 && miny != 21) {
       			cnt++;
           		if(cnt == size) {
       				size++;
       				cnt = 0;
       			}
   				map[idx1][idx2] = 0;
       			time += visit[minx][miny];
       			idx1 = minx;
       			idx2 = miny;
           	}
           	else
           		break;
    	}
       	System.out.println(time);
    }
        
    static void bfs(int x, int y) {
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {x,y});
    	visit[x][y] = 0;
    	while(!queue.isEmpty()) {
    		int qx = queue.peek()[0];
   			int qy = queue.peek()[1];
           	queue.poll();
    		for(int i = 0; i<4; i++) {
            	int nx = qx + dx[i];
            	int ny = qy + dy[i];

            	if(nx<0 || ny<0 || nx>=n || ny>=n)
            		continue;
            	
            	if(map[nx][ny] > size || visit[nx][ny] != -1)
            		continue;
            	
            	visit[nx][ny] = visit[qx][qy] +1;
            	
            	if(map[nx][ny] != 0 && map[nx][ny]<size) {
            		if(mind > visit[nx][ny]){
                        minx = nx;
                        miny = ny;
                        mind = visit[nx][ny];
                    }
                    else if(mind == visit[nx][ny]){
                        if(minx == nx){
                            if(miny > ny){
                                minx = nx;
                                miny = ny;
                            }
                        }else if(minx > nx){
                            minx = nx;
                            miny = ny;
                        }
                    }
                }	
            	queue.offer(new int[] {nx,ny});
    		}
    	}
    }
}
