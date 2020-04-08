//백준 알고리즘 1915번 : 가장 큰 정사각형
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[][] board = new int[n][m];
       for(int i = 0 ; i<n; i++) {
    	   String s = sc.next();
    	   String[] st;
    	   st = s.split("");
    	   for(int j = 0 ; j<m; j++) {
    		   board[i][j] = Integer.parseInt(st[j]);
    	   }
       }
       int max = 0;
       
       if(n <=1 || m <=1) {
    	   for(int i =0 ;i<n; i++) {
    		   for(int j = 0 ; j<m; j++) {
    			   if(board[i][j] == 1)
    				   max = 1;
    		   }
    	   }
       }

       for(int i = 1; i<n; i++) {
    	   for(int j = 1; j<m; j++) {
    		   if(board[i][j] == 1) {
    			   board[i][j] = Math.min(Math.min(board[i-1][j],board[i][j-1]), board[i-1][j-1])+1;
    		   }
    		   if(board[i][j] > max) {
    			   max = board[i][j];
    		   }
    	   }
       } 
       System.out.println(max*max);
    }
}
