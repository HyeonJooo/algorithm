import java.io.*;
import java.util.*;
public class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visit;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0;  i<n; i++) {
            for(int j = 0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visit = new boolean[n];

        //시작도시가 i일 때부터 가능한 경로 탐색
        //다음 도시가 0이면 다시 되돌아와서 다음경로로.
        for(int i = 0;  i<n; i++) {
            dfs(i,i,0,0);
        }
        System.out.println(min);
    }

    public static void dfs(int start, int i, int cnt, int sum) {
        if(cnt==arr.length && start==i) {
            min = Math.min(min, sum);
            return;
        }

        for(int j = 0; j<arr.length; j++) {
            if(arr[i][j]==0)
                continue;

            if(!visit[i] && arr[i][j] > 0) {
                sum += arr[i][j];
                visit[i] = true;
                dfs(start, j, cnt+1, sum);
                visit[i] = false;
                sum -= arr[i][j];
            }
        }
    }
}
