import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n+1][n+1];

        for(int i = 0 ; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
             arr[a][b] = 1;
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

        int s = sc.nextInt();
        for(int i = 0 ; i<s; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(arr[a][b] != 0 && arr[a][b] != 10000001)
                System.out.println(-1);

            else if(arr[b][a] != 0 && arr[b][a] != 10000001)
                System.out.println(1);

            else
                System.out.println(0);
        }
    }
}
