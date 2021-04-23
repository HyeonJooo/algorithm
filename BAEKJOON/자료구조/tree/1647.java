import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int to;
    int value;

    public Node(int start, int to, int value) {
        this.start = start;
        this.to = to;
        this.value = value;
    }

    public int compareTo(Node arg0) {
        return arg0.value >= this.value ? -1 : 1;
    }
}

public class Main {
    public static int[] parent;
    public static PriorityQueue<Node> queue;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        queue = new PriorityQueue<>();

        for(int i = 0 ; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Node(a,b,c));
        }

        for(int i = 0 ; i<=n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int max = -1;
        for(int i = 0; i<m; i++) {
            Node node = queue.poll();
            if(find(node.start) == find(node.to))
                continue;
            union(node.start, node.to);
            answer += node.value;
            max = Math.max(max, node.value);
        }
        System.out.println(answer-max);
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
        return parent[a] = find(parent[a]);
    }
}
