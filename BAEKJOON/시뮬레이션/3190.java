//백준 알고리즘 3190번 : 뱀
import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    	int n = sc.nextInt();//보드 크기
    	int k = sc.nextInt();//사과 개수
    	arr = new int[n+1][n+1];
    	for(int i = 0; i<k; i++) {
    		int r = sc.nextInt();
    		int c = sc.nextInt();
    		arr[r][c] = 1;
    	}
    	int l = sc.nextInt();//방향 변환 횟수
    	check = new boolean[n+1][n+1];
		int count = 0;
		int x = 1, y = 2;
		int a = 1;
		int curdir = 1;
		boolean[] anscheck = new boolean[1];
		anscheck[0] = false;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {1,1});
		
    	for(int i = 0 ; i<l; i++) {
    		int time = sc.nextInt();
    		String dir = sc.next();
    		
    	   	for(int j = a; j<=time; j++) {
    	   		if(anscheck[0] == true)
    	   			break;
    	   		
    	   		else if(x>n || y>n || x<=0 || y<=0 || check[x][y]==true) {
    	   			anscheck[0] = true;
   	    	    	count++;
    	    		break;
    	    	}
	
   	    		else {
   	    	    	count++;
   	    	    	a++;
   	    			if(arr[x][y] == 1) {//사과있음
   	        			arr[x][y] = 0;
            			check[queue.peek()[0]][queue.peek()[1]] = true;
    	       			queue.offer(new int[] {x,y});
    	       			check[x][y] = true;
    	       		}
    	       		else {
    	       			check[x][y] = true;
    	       			check[queue.peek()[0]][queue.peek()[1]] = false;
    	       			queue.offer(new int[] {x,y});
    	       			queue.poll();
    	        	}	
    	    	}
    	   		if(j==time && dir.equals("D")) {
    	    		curdir = (curdir + 3) % 4;
    		   		x = x + dx[curdir];
    		   		y = y + dy[curdir];
    		    }
   	    		else if(j==time && dir.equals("L")) {
   	    			curdir = (curdir + 1) % 4;
   		    		x = x + dx[curdir];
    	    		y = y + dy[curdir];
    	    	}
    	   		else {
    	    		x = x + dx[curdir];
    	    		y = y + dy[curdir];
   	    		}
        	}    			
    	}
    	if(anscheck[0] == false) {
    		while(true) {
    			count++;
    			if(x>n || y>n || x<=0 || y<=0 || check[x][y]==true) {
    	   			anscheck[0] = true;
    	    		break;
    	    	}
    			else {
   	    			if(arr[x][y] == 1) {//사과있음
   	        			arr[x][y] = 0;
            			check[queue.peek()[0]][queue.peek()[1]] = true;
    	       			queue.offer(new int[] {x,y});
    	       			check[x][y] = true;
    	       		}
    	       		else {
    	       			check[x][y] = true;
    	       			check[queue.peek()[0]][queue.peek()[1]] = false;
    	       			queue.offer(new int[] {x,y});
    	       			queue.poll();
    	        	}	
    	    	}
	    		x = x + dx[curdir];
	    		y = y + dy[curdir];
    		}
    	}
    	System.out.println(count);
    }
}
