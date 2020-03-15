//2018 카카오 신입공채 1차 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
       String[][] arr1ch = new String[n][n];
       String[][] arr2ch = new String[n][n];
       String[] answer = new String[n];
       
       for(int i = 0 ; i<n; i++) {
    	   String bi1 = Integer.toBinaryString(arr1[i]);
    	   while(bi1.length() != n)
    		   bi1 = "0" + bi1;
    	   arr1ch[i] = bi1.split("");
    	   
    	   String bi2 = Integer.toBinaryString(arr2[i]);
    	   while(bi2.length() != n)
    		   bi2 = "0" + bi2;
    	   arr2ch[i] = bi2.split("");
       }
	   String tmp = "";       
       for(int i = 0 ; i<n; i++) {
		   tmp = "";
    	   for(int j = 0; j<n; j++) {
    		   if(arr1ch[i][j].equals("1") || arr2ch[i][j].equals("1"))
    			   tmp += "#";
    		   else
    			   tmp += " ";
    	   }
    	   answer[i] = tmp;
       }
      return answer;
  }
}
