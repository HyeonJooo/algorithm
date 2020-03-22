//백준 알고리즘 11047번 : 동전0
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	int[] arr = new int[n];
    	
    	for(int i = 0; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	int count = 0;
    	for(int i = n; i>0; i--) {
        	count += k/arr[i-1];
        	k %= arr[i-1];    		
    	}
    	System.out.println(count);  	
    }
}
