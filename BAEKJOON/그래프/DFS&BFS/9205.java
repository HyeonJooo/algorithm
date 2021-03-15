import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n,fes1,fes2,start1,start2;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
            n = sc.nextInt();
            start1 = sc.nextInt();
            start2 = sc.nextInt();
            arr = new int[n+1][2];
            visit = new boolean[n+1];

            for(int i = 0 ; i<n+1; i++) {
                for(int j = 0 ; j<2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            fes1 = arr[n][0]; //페스티벌 x좌표
            fes2 = arr[n][1]; //페스티벌 y좌표

            bfs();
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {start1, start2});
        int d = 0;
        boolean success = false;

        while(!queue.isEmpty()) {
            int qx = queue.peek()[0];
            int qy = queue.peek()[1];
            queue.poll();

            if(qx==fes1 && qy==fes2) {
                System.out.println("happy");
                success = true;
            }

            for(int i = 0; i<n+1; i++) {
                if(!visit[i] && Math.abs(qx-arr[i][0])+Math.abs(qy-arr[i][1]) <= 1000) {
                    queue.offer(new int[] {arr[i][0], arr[i][1]});
                    visit[i] = true;
                }
            }
        }
        if(!success)
            System.out.println("sad");
    }
}
