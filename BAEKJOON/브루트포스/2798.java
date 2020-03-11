//백준 알고리즘 2798번 : 블랙잭
import java.io.*;
import java.util.*;
public class Main {
	
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int[] arr = new int[n];
       
       for(int i = 0; i<arr.length; i++) {
    	   arr[i] = sc.nextInt();
       }
       
       int ans = 0;
       for(int i = 0; i<n-2; i++) {
    	   for(int j = i+1; j<n-1; j++) {
    		   for(int k = j+1; k<n; k++) {
        		   if(arr[i]+arr[j]+arr[k] <=m && arr[i]+arr[j]+arr[k]>=ans)
        			   ans = arr[i]+arr[j]+arr[k];    			   
    		   }
    	   }
       }
       System.out.println(ans);       
    }
}
