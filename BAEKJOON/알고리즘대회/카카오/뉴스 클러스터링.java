//2018년 카카오 신입공채 1차 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
  public int solution(String str1, String str2) {
      int answer = 0;
      str1 = str1.toUpperCase();
       str2 = str2.toUpperCase();  
       int inter  = 0, union = 0;
       List<String> list1 = new LinkedList<String>();
       List<String> list2 = new LinkedList<String>();
       
       for(int i = 0; i<str1.length()-1; i++) {
    	   String tmp = "";
    	   if((int)str1.charAt(i) >=65 && (int)str1.charAt(i) <=90 && 
    			   (int)str1.charAt(i+1) >= 65 && (int)str1.charAt(i+1) <=90) {
    		   tmp += str1.charAt(i);
    		   tmp += str1.charAt(i+1);
    		   list1.add(tmp);
    	   }
       }
       
       for(int i = 0; i<str2.length()-1; i++) {
    	   String tmp = "";
    	   if((int)str2.charAt(i) >=65 && (int)str2.charAt(i) <=90 && 
    			   (int)str2.charAt(i+1) >= 65 && (int)str2.charAt(i+1) <=90) {
    		   tmp += str2.charAt(i);
    		   tmp += str2.charAt(i+1);
    		   list2.add(tmp);
    	   }
       }
       if(list1.size()==0 && list2.size()==0)
    	   answer = 65536;
       
       else {
           union += list2.size();
           for(int i = 0 ; i<list1.size(); i++) {
        	   String s = list1.get(i);
        	   if(!list2.contains(s)) //집합B에 A의 원소가 없으면 합집합 개수++
        		   union++;
        	   
        	   if(list2.contains(s)) {//집합B에 A의 원소가 있으면 교집합 개수++
        		   inter++;
        		   for(int j = 0; j<list2.size(); j++) {
        			   if(list2.get(j).equals(s)) { 
        				   list2.remove(j);//집합 B에서 해당 원소 삭제
        				   break;
        			   }
        		   }
        	   }
        	   else
        		   continue;
           }
           answer = (int)Math.floor((double)inter/union*65536);
       }
      return answer;
  }
}
