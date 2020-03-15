//2018 카카오 신입공채 1차 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
  public int solution(String dartResult) {
        String[] arr;
       arr = dartResult.split("");
       int[] ans = new int[3];

       int i = 0;
       String tmp = "";
       int num = 0;
       int cnt = 0;

       while(i != arr.length) {    
           if(dartResult.charAt(i) - '0' >= 0 && dartResult.charAt(i) - '0' <= 9) {
               tmp += arr[i];
               i++;
           }

           else if(arr[i].equals("S") || arr[i].equals("D") ||arr[i].equals("T")) {
               cnt++;
               num = Integer.parseInt(tmp);
               if(arr[i].equals("S"))
                   ans[cnt-1] = num;

               else if(arr[i].equals("D"))
                   ans[cnt-1] = num*num;

               else
                   ans[cnt-1] = num*num*num;
               i++;
               tmp = "";
           }

           else {
               if(arr[i].equals("*")) {
                   if(cnt==1) 
                       ans[0] *= 2;
                   else {
                       ans[cnt-1] *= 2;
                       ans[cnt-2] *= 2;
                   }
               }
               else {
                   ans[cnt-1] *= -1;
               }
               i++;
           }
       }
       int answer = ans[0] + ans[1] + ans[2];
      return answer;
  }
}
