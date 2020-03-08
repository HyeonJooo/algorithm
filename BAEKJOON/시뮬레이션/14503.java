//백준 알고리즘 14503번 : 로봇청소기
import java.io.*;
import java.util.*;
public class Main {
	static int n,m,r,c,d;
	static int[][] arr;
	static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};			
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        
        for(int i = 0 ; i<n; i++) {
           for(int j = 0 ; j<m; j++) {
              arr[i][j] = sc.nextInt();
           }
        }
        int count = 0;
        
        while(true) {
        	if(arr[r][c] == 0)
        		arr[r][c] = 2;
        	
        	else {
        		if(arr[r+1][c] != 0 && arr[r][c+1] != 0 && arr[r-1][c] != 0 && arr[r][c-1] != 0) {
        			if(arr[r-dx[d]][c-dy[d]] == 1)
        				break;
        			else {
        				r = r-dx[d];
        				c = c-dy[d];
        			}
        		}
        		else {
        			d = (d+3) % 4;
        			
        			if(arr[r+dx[d]][c+dy[d]] == 0) {
        				r = r+dx[d];
        				c = c+dy[d];
        			}
        		}
        	}
        }
        
        for(int i = 0 ; i<n; i++) {
        	for(int j = 0; j<m; j++) {
        		if(arr[i][j]==2)
        			count++;
        	}
        }
        System.out.println(count);
    }
}
