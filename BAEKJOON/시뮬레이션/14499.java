//백준 알고리즘 14499번 : 주사위 굴리기
import java.io.*;
import java.util.*;
public class Main {
	static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};				
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m]; //지도
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();
        int[] order = new int[k];//명령어 순서대로 담아놓는 배열
        int[] dir = new int[6];//0번부터 위,아래,왼,오,뒤,앞 처음엔 다 0으로 초기화    
        for(int i = 0 ; i<n; i++) {
           for(int j = 0 ; j<m; j++) {
              arr[i][j] = sc.nextInt();
           }
        }     
        for(int i = 0 ; i<k; i++) {
        	order[i] = sc.nextInt();
        }
        for(int i = 0; i<6; i++) {
        	dir[i] = 0;
        }
        int tmp = 0;
        for(int i = 0; i<k; i++) {
        	if(x+dx[order[i]-1]>=n || y+dy[order[i]-1]>=m || x+dx[order[i]-1]<0 || y+dy[order[i]-1]<0)
        		continue;
        	
        	else {
        		if(order[i] == 1) {//동쪽이동
            		tmp = dir[3];
            		dir[3] = dir[0];
            		dir[0] = dir[2];
            		dir[2] = dir[1];
            		dir[1] = tmp;
            	}
        		else if(order[i] == 2) {//서쪽이동
            		tmp = dir[2];
            		dir[2] = dir[0];
            		dir[0] = dir[3];
            		dir[3] = dir[1];
            		dir[1] = tmp;
            	}       		
        		else if(order[i] == 3) {//북쪽이동
            		tmp = dir[4];
            		dir[4] = dir[0];
            		dir[0] = dir[5];
            		dir[5] = dir[1];
            		dir[1] = tmp;
            	}
        		else{//남쪽이동
            		tmp = dir[5];
            		dir[5] = dir[0];
            		dir[0] = dir[4];
            		dir[4] = dir[1];
            		dir[1] = tmp;
            	}
    			x = x + dx[order[i]-1];
    			y = y + dy[order[i]-1];
        		
        		if(arr[x][y] != 0) {
        			dir[1] = arr[x][y];
        			arr[x][y] = 0;
        		}
        		else {
        			arr[x][y] = dir[1];
        		}
        		
        		list.add(dir[0]);
        	}
        }    
        for(int a : list)
        	System.out.println(a);
    }
}
