import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //유저 수
        int m = sc.nextInt(); //친구관계 수

        int[][] arr = new int[n+1][n+1];

        for(int i = 0 ; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n ; j++) {
                if(i!=j && arr[i][j]==0)
                    arr[i][j] = 10000001;
            }
        }

        for(int k = 1; k<=n; k++) {
            for(int i = 1; i<=n; i++) {
                for(int j = 1; j<=n; j++) {
                    if(arr[i][k] + arr[k][j] < arr[i][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 1; i<=n; i++) {
            int sum = 0;
            for(int j = 1; j<=n; j++) {
                sum += arr[i][j];
            }
            if(ans > sum) {
                ans = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
