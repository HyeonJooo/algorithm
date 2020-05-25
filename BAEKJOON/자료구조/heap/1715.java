//백준 알고리즘 1715번 : 카드 정렬하기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Queue<Integer> pq = new PriorityQueue<>();

       for(int i = 0 ; i<n; i++) {	
    	   pq.add(sc.nextInt());
       }
       int sum = 0;
       int ans = 0;

       while(!pq.isEmpty()) {
    	   sum += pq.poll();
    	   if(pq.isEmpty()) 
    		   break;
    	   
    	   sum += pq.poll();
    	   pq.add(sum);
    	   ans += sum;
    	   sum = 0;
       }      
       System.out.println(ans);
   }
}
