import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int end;
    int value;

    public Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int[][] d = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n,d));

    }
    public static int solution(int n, int[][] edge) {
        int answer = 1;
        int[] distance = new int[n+1];
        boolean[] check = new boolean[n+1];
        ArrayList<Edge>[] list = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i< edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(new Edge(b,1));
            list[b].add(new Edge(a,1));
        }

        distance[1] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1,0));

        while(!queue.isEmpty()) {
            Edge a = queue.poll();
            if(check[a.end])
                continue;

            check[a.end] = true;
            for(Edge o : list[a.end]) {
                if(distance[o.end] > distance[a.end] + o.value) {
                    distance[o.end] = distance[a.end] + o.value;
                    queue.add(new Edge(o.end, distance[o.end]));
                }
            }
        }

        Arrays.sort(distance);
        int max = distance[distance.length-2];
        for(int i = distance.length-3; i>=0; i--) {
            if(max != distance[i])
                break;
            answer++;
        }
        return answer;
    }
}
