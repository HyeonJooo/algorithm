import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int end;
    int value;

    Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] tmp = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
        int ans = solution(n,s,a,b,tmp);
        System.out.println(ans);

    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[] distance = new int[n+1];
        boolean[] check = new boolean[n+1];
        int[][] arr = new int[n+1][n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i = 0 ; i<fares.length; i++) {
            int u = fares[i][0];
            int v = fares[i][1];
            int w = fares[i][2];
            arr[u][v] = w;
            arr[v][u] = w;
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


        for(int k = 1; k<=n; k++) {
            int sum = arr[s][k] + arr[k][a] + arr[k][b];
            answer = Math.min(sum, answer);
        }
        return answer;
    }
}
