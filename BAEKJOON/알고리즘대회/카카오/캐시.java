//2018년 카카오 신입공채 1차 코딩테스트
import java.io.*;
import java.util.*;
class Solution {
  public int solution(int cacheSize, String[] cities) {
             ArrayList<String> queue = new ArrayList<String>();
       int answer = 0;
       
       if(cacheSize == 0) {
    	   answer = cities.length * 5;
       }
       
       else {
           for(int i = 0; i<cities.length; i++) {
        	   String tmp = cities[i];
        	   tmp = tmp.toUpperCase();
        	   if(!queue.contains(tmp)) {//캐시에 단어가 없으면
        		   if(queue.size() < cacheSize)//큐가 비어있으면 
        			   queue.add(tmp); //큐에 추가
        		   else {
        			   queue.remove(0);//캐시 사이즈보다 크면 하나 삭제하고
        			   queue.add(tmp);//추가
        		   }
        		   answer += 5; //cache miss
        	   }

        	   else {//캐시에 있으면
        		   for(int j = 0; j<queue.size(); j++) {
        			   if(queue.get(j).equals(tmp)) {
        				   queue.remove(j);//캐시에서 그 단어를 찾아서 삭제한 뒤
        				   queue.add(tmp);//다시 삽입
        				   break;
        			   }
        		   }
        		   answer += 1;
        	   }
           }
       }
      return answer;
  }
}
