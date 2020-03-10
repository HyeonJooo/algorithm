//백준 알고리즘 14499번 : 주사위 굴리기
import java.io.*;
import java.util.*;
public class Main {				
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<Integer>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[n][m]; //지도
        int[] order = new int[k];//명령어 순서대로 담아놓는 배열
        int[] dir = new int[7];//1번부터 위, 뒤,오,왼,앞,아래    
    	int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        for(int i = 0 ; i<n; i++) {
           for(int j = 0 ; j<m; j++) {
              arr[i][j] = sc.nextInt();
           }
        }     
        for(int i = 0 ; i<k; i++) {
        	order[i] = sc.nextInt();
        }
        for(int i = 1; i<=6; i++) {
        	dir[i] = 0;
        }
        int tmp = 0;
        for(int i = 0; i<k; i++) {
        	if(x+dx[order[i]-1]>=n || y+dy[order[i]-1]>=m || x+dx[order[i]-1]<0 || y+dy[order[i]-1]<0)
        		continue;
        	
        	else {
        		if(order[i] == 1) {//동쪽이동
            		tmp = dir[3];
            		dir[3] = dir[1];
            		dir[1] = dir[4];
            		dir[4] = dir[6];
            		dir[6] = tmp;
            	}
        		else if(order[i] == 2) {//서쪽이동
            		tmp = dir[4];
            		dir[4] = dir[1];
            		dir[1] = dir[3];
            		dir[3] = dir[6];
            		dir[6] = tmp;
            	}       		
        		else if(order[i] == 3) {//북쪽이동
            		tmp = dir[2];
            		dir[2] = dir[1];
            		dir[1] = dir[5];
            		dir[5] = dir[6];
            		dir[6] = tmp;
            	}
        		else{//남쪽이동
            		tmp = dir[5];
            		dir[5] = dir[1];
            		dir[1] = dir[2];
            		dir[2] = dir[6];
            		dir[6] = tmp;
            	}
    			x = x + dx[order[i]-1];
    			y = y + dy[order[i]-1];
        		
        		if(arr[x][y] != 0) {//칸에 쓰여있는 수가 0이 아니면
        			dir[6] = arr[x][y];//그 수가 주사위 바닥면에 복사되고
        			arr[x][y] = 0;//칸에 쓰여있는 수는 0이 된다.
        		}
        		else {//칸에 쓰여있는 수가 0이면
        			arr[x][y] = dir[6];//주사위 바닥면의 수가 칸에 복사된다.
        		}
        		
        		list.add(dir[1]);//주사위 윗면의 수 추가
        	}
        }    
        for(int a : list)
        	System.out.println(a);
    }
}
