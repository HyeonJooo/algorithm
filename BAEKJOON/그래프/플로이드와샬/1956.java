import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] arr = new int[v+1][v+1];
        for(int i = 0 ; i<e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(arr[a][b] > c || arr[a][b] == 0)
                arr[a][b] = c;
        }

        for(int i = 1; i<=v; i++) {
            for(int j = 1; j<=v; j++) {
                if(i!=j && arr[i][j] == 0)
                    arr[i][j] = 10000001;
            }
        }

        for(int k = 1; k<=v; k++) {
            for(int i = 1; i<=v; i++) {
                for(int j = 1; j<=v; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i =1 ; i<=v; i++) {
            for(int j =1 ; j<=v; j++) {
                if(i!=j) {
                    min = Math.min(min, arr[i][j] + arr[j][i]);
                }
            }
        }
        if(min > 10000000)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
