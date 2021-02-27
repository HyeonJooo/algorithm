import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int to;
    double cost;

    public Node(int start, int to, double cost) {
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
    static int n; //정점 개수
    static PriorityQueue<Node> pq;
    static int[] parent;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //별의 개수
        parent = new int[n+1];
        visit = new boolean[n+1];
        double result = 0;
        pq = new PriorityQueue<Node>();
        double[][] star = new double[n][2];

        for(int i = 0; i<n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st1.nextToken());
            double b = Double.parseDouble(st1.nextToken());
            star[i][0] = a;
            star[i][1] = b;
        }

        for(int i = 0 ; i<star.length-1; i++) {
            for(int j = i+1; j<n; j++) {
                double d = Math.sqrt(Math.pow(star[j][0]-star[i][0],2) + Math.pow(star[j][1]-star[i][1],2));
                pq.add(new Node(i,j,d));
            }
        }

        for(int i = 0; i<=n; i++) {
            parent[i] = i;
        }

        for(int i = 0 ; i<n*(n-1)/2; i++) {
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
        System.out.printf("%.2f\n", result);
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
