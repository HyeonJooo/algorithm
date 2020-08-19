import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	static int blue = 0, white = 0;
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		arr[i][j] = sc.nextInt();
        	}
        }
        recursive(n,0,0);
        System.out.println(white);
        System.out.println(blue);
        
	}
	static void recursive(int n, int x, int y) {
		int num = arr[x][y];
		
		for(int i = x ; i<n+x; i++) {
			for(int j = y ; j<n+y; j++) {
				int tmp = arr[i][j];
				if(num != tmp) {
					num = -1;
					break;
				}
				if(num == -1)
					break;
			}
		}
		
		if(num == 1)
			blue++;
		else if(num == 0)
			white++;
		else if(num == -1) {
			recursive(n/2,x,y);
			recursive(n/2,x+n/2,y);
			recursive(n/2,x,y+n/2);
			recursive(n/2,x+n/2,y+n/2);			
		}
	}
}
