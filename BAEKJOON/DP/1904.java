//백준 알고리즘 1904번 : 01타일
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        
    	if(n==1) {
    		System.out.println(1);
    		System.exit(0);
    	}
    	if(n==2) {
    		System.out.println(2);
    		System.exit(0);
    	}
    	
    	arr[1] = 1;
    	arr[2] = 2;
    	
    	for(int i = 3; i<=n; i++) {
    		arr[i] = (arr[i-1] + arr[i-2]) % 15746; 
    	}
        System.out.println(arr[n]);
    }
}
