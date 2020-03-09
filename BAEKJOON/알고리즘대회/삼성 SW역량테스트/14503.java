//백준 알고리즘 14503번 : 로봇 청소기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);       
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        int[][] arr = new int[n][m];
    	int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        
        for(int i = 0 ; i<n; i++) {
           for(int j = 0 ; j<m; j++) {
              arr[i][j] = sc.nextInt();
           }
        }
        int count = 0;
        
        while(true) {
        	if(arr[r][c] == 0)
        		arr[r][c] = 2; //현재위치 청소
        	
        	else {//네 방향 모두 청소 되어있거나, 벽인 경우
        		if(arr[r+1][c] != 0 && arr[r][c+1] != 0 && arr[r-1][c] != 0 && arr[r][c-1] != 0) {
        			if(arr[r-dx[d]][c-dy[d]] == 1) //뒤쪽 방향이 벽이라 후진도 할 수 없는 경우
        				break;//작동을 멈춤
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
