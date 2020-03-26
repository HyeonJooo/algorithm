//2019 KOI 2차대회 초등부
//백준 알고리즘 17614번 : 369
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
	   
       int cnt = 0;
       int tmp = 0;
       
       for(int i = 1; i<=n; i++) {
    	   tmp = i;
    	   
    	   while(tmp != 0) {
    		   if(tmp %10 == 3 || tmp %10 == 6 || tmp %10 == 9)
    			   cnt++;
    		   tmp /= 10;
    	   }
       }
       System.out.println(cnt);
    }
}
