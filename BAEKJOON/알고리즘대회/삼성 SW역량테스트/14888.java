//백준 알고리즘 14888번 : 연산자 끼워넣기
import java.io.*;
import java.util.*;
public class Main {
	static int arr[], op[];
	static int m,n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       arr = new int[n]; // 숫자들
       op = new int[4]; //연산자별 개수. 0부터 +,-,*,/
       
       for(int i = 0 ; i<n; i++) {
    	   arr[i] = sc.nextInt();
       }
       
       for(int i = 0 ; i <4; i++) {
    	   op[i] = sc.nextInt();
       }
       
       dfs(1, arr[0]);
       System.out.println(max);
       System.out.println(min);
       
    }
	static void dfs(int next, int sum) {
		
		for(int i = 0 ; i<4; i++) {
			if(op[i] != 0) {
				op[i]--;
				
				switch (i) {
				case 0:
					dfs(next + 1, sum + arr[next]);
					break;
				case 1:
					dfs(next + 1, sum - arr[next]);
					break;
				case 2:
					dfs(next + 1, sum * arr[next]);
					break;
				case 3:
					dfs(next + 1, sum / arr[next]);
					break;
				}
				op[i]++;
			}
		}
		
		if(next == n) {
			if(min > sum)
				min = sum;
			if(max < sum)
				max = sum;
		}	
	}
}
