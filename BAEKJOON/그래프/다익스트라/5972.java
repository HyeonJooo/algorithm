import java.io.*;
import java.lang.reflect.Array;
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
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge>[] list = new ArrayList[n+1];
        int[] distance = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i = 1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i = 0 ; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        distance[1] = 0;

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
        System.out.println(distance[n]);
    }
}
