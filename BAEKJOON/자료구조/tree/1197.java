import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int to;
    int cost;

    public Node(int start, int to, int cost) {
        this.start = start;
        this.to = to;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node arg0) {
        return arg0.cost >= this.cost ? -1 : 1;
    }
}

public class Main {
    static int v; //정점 개수
    static int e; //간선 개수
    static PriorityQueue<Node> pq;
    static int[] parent;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken()); //정점의 개수
        e = Integer.parseInt(st.nextToken()); //간선 개수
        parent = new int[v+1];
        visit = new boolean[v+1];
        long result = 0;
        pq = new PriorityQueue<Node>();

        for(int i = 0; i<e; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());
            pq.add(new Node(a,b,c));
        }

        for(int i = 0; i<=v; i++) {
            parent[i] = i;
        }

        for(int i = 0 ; i<e; i++) {
            Node node = pq.poll();
            int start = node.start;
            int end = node.to;
            int a = find(start);
            int b = find(end);

            if(a == b)
                continue;
            union(a,b);
            result += node.cost;
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }

    public static int find(int a) {
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }
}
