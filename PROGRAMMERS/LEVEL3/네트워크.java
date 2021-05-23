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
        int n = 4;
        int[][] c = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 1, 0, 1}};
        System.out.println(solution(n,c));
    }

    static int[] parent;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n+1];
        for(int i = 1; i<=n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i<computers.length; i++) {
            for(int j = 0; j<computers[0].length; j++) {
                if(i==j)
                    continue;

                if(computers[i][j] != computers[j][i]) {
                    computers[i][j] = 1;
                    computers[j][i] = 1;
                }
                if(computers[i][j] == 1)
                    union(i+1, j+1);
            }
        }

        for(int i = 0; i<=n; i++)
            find(i);

        Arrays.sort(parent);
        int num = parent[1];
        for(int i = 2; i<=n; i++) {
            if(num != parent[i]) {
                num = parent[i];
                answer++;
            }
        }

        return answer+1;
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
