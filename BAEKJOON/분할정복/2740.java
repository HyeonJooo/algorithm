import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0 ; i<n; i++) {
        	for(int j = 0 ; j<m; j++) {
        		a[i][j] = sc.nextInt();
        	}
        }
        m = sc.nextInt();
        int k = sc.nextInt();
        int[][] b = new int[m][k];
        for(int i = 0 ; i<m; i++) {
        	for(int j = 0; j<k; j++) {
        		b[i][j] = sc.nextInt();
        	}
        }
        
        int[][] answer = new int[n][k];
        for(int i = 0 ; i<n; i++) {
        	for(int j = 0 ; j<k; j++) {
        		int sum = 0;
        		for(int q = 0; q<m; q++) {
        			sum += a[i][q]*b[q][j];
        			answer[i][j] = sum;
        		}
        	}
        }
        
        for(int i = 0 ; i<n; i++) {
        	for(int j = 0; j<k; j++) {
        		System.out.print(answer[i][j] + " ");
        	}System.out.println("");
        }
	}
}
