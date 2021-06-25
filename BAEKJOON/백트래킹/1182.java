import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int s;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        if(n==1) {
            if(arr[0] == s) {
                System.out.println(1);
                System.exit(0);
            }
        }

        boolean[] visit = new boolean[n];
        for(int i = 1; i<=n; i++) {
            dfs(arr, visit, 0, n, i);
        }
        System.out.println(answer);
    }

    static void dfs(int[] arr, boolean[] visit, int start, int n, int r) {
        int sum = 0;
        if(r == 0) {
            for(int i = 0; i<n; i++) {
                if(visit[i]) {
                    sum += arr[i];
                }
            }
            if(sum == s)
                answer++;
            return;
        }

        for(int i = start; i<n; i++) {
            visit[i] = true;
            dfs(arr, visit, i+1, n, r-1);
            visit[i] = false;
        }
    }
}
