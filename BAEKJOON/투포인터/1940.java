import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i = 0 ; i<n; i++) {
    		arr[i] = sc.nextInt();
    	}
    	int answer = 0;
    	
    	Arrays.sort(arr);
    	for(int i = 0 ; i<n-1; i++) {
    		for(int j = i+1; j<n; j++) {
    			if(arr[i]+arr[j]==m) {
    				answer++;
    				break;
    			}
    		}
    	}
    	System.out.println(answer);
    }
}
