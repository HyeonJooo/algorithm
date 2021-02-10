import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int q = sc.nextInt();

        int[][] arr = new int[r+1][c+1];
        for(int i = 1; i<=r; i++) {
            for(int j = 1; j<=c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i<=r; i++) {
            for(int j = 1; j<=c; j++) {
                if(j == 1)
                    continue;
                arr[i][j] += arr[i][j-1];
            }
        }

        for(int i = 0 ; i<q; i++) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            int sum = 0;
            for(int a = r1; a<=r2; a++) {
                sum += arr[a][c2] - arr[a][c1-1];
            }
            System.out.println(sum / ((r2-r1+1) * (c2-c1+1)));
        }
    }
}
