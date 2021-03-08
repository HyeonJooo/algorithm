import java.io.*;
import java.util.*;
public class Main {
    static long[][] arr;
    static long[][] sum;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new long[n+1][m+1];
        sum = new long[n+1][m+1];
        for(int i = 1 ; i<=n; i++) {
            String s = sc.next();
            String[] st;
            st = s.split("");
            for(int j = 0; j<m; j++) {
                arr[i][j+1] = Integer.parseInt(st[j]);
            }
        }

        for(int i = 1 ; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + arr[i][j];
            }
        }

        long ans = -1;

        // 세로3줄
        for(int i = 1 ; i<=m-2; i++) {
            for(int j = i+1; j<=m-1; j++) {
                long num1 = sum(1,1,n,i);
                long num2 = sum(1,i+1,n,j);
                long num3 = sum(1,j+1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;
            }
        }

        // 가로3줄
        for(int i = 1 ; i<=n-2; i++) {
            for(int j = i+1; j<=n-1; j++) {
                long num1 = sum(1,1,i,m);
                long num2 = sum(i+1,1,j,m);
                long num3 = sum(j+1,1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;
            }
        }

        for(int i = 1 ; i<=n-1; i++) {
            for(int j = 1; j<=m-1; j++) {
                // 세로1 가로2
                long num1 = sum(1,1,n,j);
                long num2 = sum(1,j+1,i,m);
                long num3 = sum(i+1,j+1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;

                // 가로2 세로1
                num1 = sum(1,1,i,j);
                num2 = sum(i+1,1,n,j);
                num3 = sum(1,j+1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;

                // 가로1 세로2
                num1 = sum(1,1,i,m);
                num2 = sum(i+1,1,n,j);
                num3 = sum(i+1,j+1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;

                // 세로2 가로1
                num1 = sum(1,1,i,j);
                num2 = sum(1,j+1,i,m);
                num3 = sum(i+1,1,n,m);
                if(ans < num1*num2*num3)
                    ans = num1*num2*num3;
            }
        }
        System.out.println(ans);
    }

    //x1,y1 ~ x2,y2까지의 합
    public static long sum(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
    }
}
