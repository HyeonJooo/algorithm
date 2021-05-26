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
    public int compareTo(Node arg0) {
        return arg0.cost - this.cost >= 0 ? -1 : 1;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n,costs));
    }

    static int[] parent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        parent = new int[n+1];

        for(int i =0; i<=n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i<costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            queue.offer(new Node(a,b,c));
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int start = node.start;
            int end = node.to;
            if(find(start) == find(end))
                continue;
            union(find(start), find(end));
            answer += node.cost;
        }
        return answer;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }

    static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}
