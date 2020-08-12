import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[k+1][2];
        for(int i = 1; i<=k; i++) {
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
        });
        
		int[][] dp = new int[k+1][t+1];
		dp[0][0] = 1;
		for(int i = 1; i<=k; i++) {
			for(int j = 0; j<=arr[i][1]; j++) {
				for(int a = 0; a<=t; a++) {
					if(arr[i][0]*j + a >t)
						break;
					dp[i][a+arr[i][0]*j] += dp[i-1][a];
				}
			}
		}
		System.out.println(dp[k][t]);
    }
}
