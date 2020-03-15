//백준 알고리즘 10174번 : 팰린드롬
import java.io.*;
import java.util.*;
public class Main {
public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       for(int i = 0 ; i<n; i++) {
    	   String s = br.readLine();
    	   s = s.toUpperCase();  	   
    	   String reverse = new StringBuffer(s).reverse().toString();
    	   
    	   if(reverse.equals(s))
    		   System.out.println("Yes");
    	   else
    		   System.out.println("No");
       }
	}
}
