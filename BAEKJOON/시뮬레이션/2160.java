//백준 알고리즘 2160번 : 그림 비교
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       String[][][] arr = new String[n][5][7];
       
       for(int i = 0 ; i<n; i++) {
    	   for(int j = 0 ; j<5; j++) {
    		   String s = sc.next();
    		   arr[i][j] = s.split("");
    	   }
       }
       
       int next = 0;
	   int min = Integer.MAX_VALUE;
	   int minidx1 = 0, minidx2 = 0;
	   
       for(int i = 0; i<n-1; i++) {
    	   next = i+1;
    	   while(next != n) {
        	   int cnt = 0;
        	   for(int j = 0; j<5; j++) {
        		   for(int k = 0 ; k<7; k++) {
        			   if(!arr[i][j][k].equals(arr[next][j][k]))
        				   cnt++;
        		   }
        	   }
        	   if(min > cnt) {
        		   min = cnt;
        		   minidx1 = i+1;
        		   minidx2 = next+1;
        	   }
        	   next++;
    	   }
       }
       System.out.println(minidx1 + " " + minidx2);
    }
}
