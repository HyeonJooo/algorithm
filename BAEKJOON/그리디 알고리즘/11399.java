//백준 알고리즘 11399 : ATM

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	String[] s = br.readLine().split(" ");
    	int[] arr = new int[n];
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(s[i]);
    	}
    	Arrays.sort(arr);
      
    	int sum = 0;
    	int ans = 0;
    	for(int i = 0; i<n; i++) {
    		sum += arr[i];
    		ans += sum;
    	}
    	System.out.println(ans);
    	
    }
}
