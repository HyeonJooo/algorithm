import java.io.*;
import java.util.*;
class Solution {
       static int m;
       static int num1, num2;
    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        div(arr, 0,0,arr.length);
        answer[0] = num1;
        answer[1] = num2;
        return answer;
    }
    
    public static boolean check(int[][] arr, int r, int c, int n) {
       int num = arr[r][c];
       for(int i = r; i<r+n; i++) {
          for(int j = c; j<c+n; j++) {
             if(num != arr[i][j])
                return false;
          }
       }
       m = num;
       return true;
    }
    
    public static void div(int[][] arr, int r, int c, int n) {
       int[] ans = new int[2];
       if(check(arr,r,c,n)) {
          if(m==0)
             num1++;
          else
             num2++;
       }
       else {
          int s = n/2;
          for(int i = 0 ; i<2; i++) {
             for(int j = 0 ; j<2; j++) {
                div(arr,r+s*i, c+s*j, s);
             }
          }
       }
    }
}
