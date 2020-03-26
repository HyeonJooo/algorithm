//백준 알고리즘 6378번 : 디지털 루트
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int[] num;
       
       while(true) {
    	   String s = sc.next();
    	   if(s.equals("0"))
    		   break;
    	   String[] st;
    	   st = s.split("");
    	   num = new int[st.length];
    	   for(int i = 0; i<num.length; i++) {
    		   num[i] = Integer.parseInt(st[i]);
    	   }
    	   
    	   String tmp = "";
    	   
    	   while(true) {
    		   int sum = 0;
    		   for(int i = 0 ; i<num.length; i++) {
    			   sum += num[i];
    		   }
    		   tmp = Integer.toString(sum);
    		   if(tmp.length()==1)
    			   break;
    		   else {
    			   String[] st1;
    			   st1 = tmp.split("");
    			   num = new int[st1.length];
    			   for(int i = 0; i<num.length; i++) {
    				   num[i] = Integer.parseInt(st1[i]);
    			   }
    		   }
    	   }
    	   System.out.println(tmp);
       }
       
    }
}
