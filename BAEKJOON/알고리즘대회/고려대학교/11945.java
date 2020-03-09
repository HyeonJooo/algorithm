//2016 고려대학교 프로그래밍 경시대회 4번
//백준 알고리즘 11945번 : 뜨거운 붕어빵
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	if(n==0 || m==0)
    		System.exit(0);
    	else {
    		int[][] arr = new int[n][m];
        	for(int i = 0; i<n; i++) {
            	String s = sc.next();
            	String[] st = s.split("");
        		for(int j = 0; j<m; j++) {
        			arr[i][j] = Integer.parseInt(st[j]);
        		}
        	}
        
        	for(int i = 0; i<n; i++) {
        		for(int j = m-1; j>=0; j--) {
        			System.out.print(arr[i][j]);
        		}System.out.println("");
        	}		
    	}
    }
}
