import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3}, {3,5,2},{3,5,3},{5,6,1}};
        int k = 4;
        System.out.println(solution(n, road, k));

    }
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] arr = new int[N+1][N+1];
        for(int i = 0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if(arr[a][b]>c || arr[a][b] == 0) {
                arr[a][b] = c;
                arr[b][a] = c;
            }
        }

        for(int i = 1; i<=N; i++) {
            for(int j = 1; j<=N; j++) {
                if(i!=j && arr[i][j]==0)
                    arr[i][j] = 10000001;
            }
        }

        for(int k = 1; k<=N; k++) {
            for(int i = 1; i<=N; i++) {
                for(int j = 1; j<=N; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for(int i = 1; i<=N; i++) {
            if(arr[1][i] <= K)
                answer++;
        }

        return answer;
    }
}
