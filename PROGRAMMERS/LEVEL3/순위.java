import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[][] r = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n,r));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n+1][n+1];
        for(int i = 0; i<results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            arr[b][a] = 1;
        }

        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=n; j++) {
                if(i!=j && arr[i][j] == 0)
                    arr[i][j] = 10000001;
            }
        }

        for(int k = 1; k<=n; k++) {
            for(int i = 1; i<=n; i++) {
                for(int j = 1; j<=n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for(int i = 1; i<=n; i++) {
            boolean ch = false;

            for(int j = 1; j<=n; j++) {
                if(i!=j && arr[i][j] == 10000001) {
                    if(arr[j][i] == 10000001) {
                        ch = true;
                        break;
                    }
                }
            }
            if(!ch)
                answer++;
        }

        return answer;
    }
}
