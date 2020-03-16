//2018년 카카오 신입공채 1차 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
  public int solution(int m, int n, String[] board) {
       String[][] arr = new String[m][n];
       boolean[][] check = new boolean[m][n];
       for(int i = 0 ; i <m; i++) {
    	   arr[i] = board[i].split("");
       }
      
       int answer = 0;
       int exit = 1;
      
       while(true) {
           for(int i = 0 ; i<m-1; i++) {
        	   for(int j = 0 ; j<n-1; j++) {
        		   if(arr[i][j].equals(arr[i][j+1]) && arr[i][j+1].equals(arr[i+1][j]) && 
        				   arr[i+1][j].equals(arr[i+1][j+1]) && arr[i][j] != "0") {//2X2가 모두 같으면
        			   check[i][j] = true;
        			   check[i+1][j] = true;
        			   check[i][j+1] = true;
        			   check[i+1][j+1] = true;
        		   }
        	   }
           }
           for(int i = 0 ; i<m; i++) {
        	   for(int j = 0 ; j<n; j++) {
        		   if(check[i][j] == true) {
        			   if(i!=0) {
        				   for(int k = i; k>0; k--) {
        					   arr[k][j] = arr[k-1][j];//위에서 블록 떨어짐
        				   }
        				   arr[0][j] = "0";
        			   }
        			   else {//가장 윗줄이 없어지면 더이상 내려올 게 없으므로 그냥0으로 바꿈
        				   arr[i][j] = "0";
        			   }
        			   check[i][j] = false;
        			   answer++;
        		   }
        		   else
        			   exit++;
        	   }
           }
           if(exit == m*n)//모두 false이면 더이상 저이상 사라질 블록이 없으므로 탈출
        	   break;
           else
        	   exit = 0;
       }
      return answer;
  }
}
