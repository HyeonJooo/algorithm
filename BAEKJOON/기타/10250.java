//백준 알고리즘 10250번 : ACM 호텔
import java.util.*;
import java.io.*;
public class Main{
   public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      int x=0, y=0;
      
      for(int i = 0; i<t; i++) {
    	     String[] s = br.readLine().split(" ");
    	      int h = Integer.parseInt(s[0]);
    	      int w = Integer.parseInt(s[1]);
    	      int n = Integer.parseInt(s[2]);	
    	      
    	      if((n-1)/h +1 >=10)
    	    	  System.out.printf("%d%d\n", (n-1)%h+1, (n-1)/h+1);
    	      else
    	    	  System.out.printf("%d0%d\n", (n-1)%h+1, (n-1)/h+1);
      }
   }
}
