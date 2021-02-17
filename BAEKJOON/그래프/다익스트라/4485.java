import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int value;

    Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int n,m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true){
            int N = sc.nextInt();
            if(N==0)
                break;

            ArrayList<Edge>[] list = new ArrayList[N+1];
            int[][] distance = new int[N][N];
            map = new int[N][N];
            for(int i = 0; i<N; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0 ; i<N; i++){
                for(int j = 0 ; j<N; j++){
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }

            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            //시작노드값 초기화
            distance[0][0] = map[0][0];

            PriorityQueue<Edge> queue = new PriorityQueue<>();
            queue.offer(new Edge(0,0,distance[0][0]));
            int answer = 0;
            while(!queue.isEmpty()) {
                Edge a = queue.poll();
                int qx = a.start;
                int qy = a.end;

                for(int i = 0 ; i<4; i++){
                    int nx = qx + dx[i];
                    int ny = qy + dy[i];
                    if(nx<0 || ny<0 || nx>=N || ny>=N)
                        continue;

                    if(distance[nx][ny] > map[nx][ny] + a.value){
                        distance[nx][ny] = map[nx][ny] + a.value;
                        queue.offer(new Edge(nx,ny,distance[nx][ny]));
                    }
                }
            }
            answer = distance[N-1][N-1];
            System.out.println("Problem " + tc + ": " + answer);
            tc++;
        }
    }
}
