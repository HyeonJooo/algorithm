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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        queue = new PriorityQueue<>();

        for(int i = 0 ; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            queue.add(new Node(a,b,c));
        }

        for(int i = 0 ; i<=n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for(int i = 0; i<m; i++) {
            Node node = queue.poll();
            if(find(node.start) == find(node.to))
                continue;
            union(node.start, node.to);
            answer += node.value;
        }
        System.out.println(answer);
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
