//백준 알고리즘 2563번 : 색종이
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[][] arr = new int[n][2];
    	for(int i = 0; i<n; i++) {
    		arr[i][0] = sc.nextInt();
    		arr[i][1] = sc.nextInt();
    	}
    	boolean[][] check = new boolean[100][100];
    	for(int i = 0 ; i<n; i++) {
    		for(int j = arr[i][0]; j<arr[i][0]+10; j++) {
    			for(int k = arr[i][1]; k<arr[i][1]+10; k++) {
    				check[j][k] = true;
    			}
    		}
    	}
    	int cnt = 0;
    	for(int i = 0 ; i<100; i++) {
    		for(int j = 0 ; j<100; j++) {
    			if(check[i][j] == true)
    				cnt++;
    		}
    	}
    	System.out.println(cnt);
    }
}
