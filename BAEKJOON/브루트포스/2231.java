import java.io.*;
import java.util.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
   	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 	   
  	   int n = Integer.parseInt(br.readLine());   
       int ans = 0;
	   int c = 1, d = 1;       
       while(true) {
    	   c = d;
           while(c != 0) {
        	   ans += (c%10);
        	   c/=10;
           }
           if(d+ans == n) {
        	   System.out.println(d);
        	   break;
           }
           else if(d>=n) {
        	   System.out.println(0);
        	   break;
           }
           else {
        	   d++;
        	   ans = 0;
           }
       }    
       bw.flush();
       br.close();
       bw.close();
    }
}
