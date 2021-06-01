import java.io.*;
import java.util.*;

public class Main {

    static boolean[] check;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        int[][] arr = new int[n+1][n+1];

        for(int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        check = new boolean[arr.length+1];
        dfs(arr,v);
        System.out.println();
        bfs(arr,v);
    }

    static void bfs(int[][] arr, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        boolean[] visit = new boolean[arr.length+1];
        visit[v] = true;

        while(!queue.isEmpty()) {
            int a = queue.poll();
            System.out.print(a + " ");

            for(int i = 1; i<arr.length; i++) {
                if(arr[a][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    static void dfs(int[][] arr, int v) {
        check[v] = true;
        System.out.print(v + " ");

        for(int i = 1; i<arr.length; i++) {
            if(arr[v][i] == 1 && !check[i])
                dfs(arr, i);
        }
    }
}
