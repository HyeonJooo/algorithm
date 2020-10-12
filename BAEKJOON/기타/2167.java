import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<m; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        
        int k = sc.nextInt();

        for(int a = 0 ; a<k; a++){
        	int i = sc.nextInt();
           	int j = sc.nextInt();
           	int x = sc.nextInt();
           	int y = sc.nextInt();
            long answer = 0;           	
           	for(int q = i-1; q<=x-1; q++) {
           		for(int w = j-1; w<=y-1; w++) {
           			answer += arr[q][w];
           		}
           	}
           	System.out.println(answer);
        }
    }
}
