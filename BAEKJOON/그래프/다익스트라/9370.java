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
    static int[] distance;
    static boolean[] check;
    static ArrayList<Edge>[] list;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc<T; tc++) {
            n = sc.nextInt(); //교차로
            int m = sc.nextInt(); //도로
            int t = sc.nextInt(); //목적지 후보 개수

            int s = sc.nextInt(); //출발지
            int g = sc.nextInt();
            int h = sc.nextInt();

            distance = new int[n+1];
            int[] goal = new int[t];
            check = new boolean[n+1];
            list = new ArrayList[n+1];
            for(int i = 1; i<=n; i++) {
                list[i] = new ArrayList<>();
            }
            Arrays.fill(distance, Integer.MAX_VALUE);
            int GtoH = 0;

            for(int i = 0; i<m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt(); // a,b 사이 길이
                if((a==g && b==h) || (a==h && b==g))
                    GtoH = d;
                list[a].add(new Edge(b,d));
                list[b].add(new Edge(a,d));
            }

            for(int i = 0; i<t; i++) {
                goal[i] = sc.nextInt(); //목적지 후보들
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            int toG = dij(s, g);
            int toH = dij(s, h);
            for(int i = 0; i<t; i++) {
                int GtoX = dij(g, goal[i]);
                int HtoX = dij(h, goal[i]);
                int StoX = dij(s, goal[i]);

                if(toG == toH + GtoH) {
                    if(StoX == toG + GtoX) {
                        queue.add(goal[i]);
                        continue;
                    }
                }
                else {
                    if(StoX == toG + GtoH + HtoX) {
                        queue.add(goal[i]);
                        continue;
                    }
                }

                if(toH == toG + GtoH) {
                    if(StoX == toH + HtoX) {
                        queue.add(goal[i]);
                        continue;
                    }
                }
                else {
                    if(StoX == toH + GtoH + GtoX) {
                        queue.add(goal[i]);
                        continue;
                    }
                }
            }

            while(!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }

    static int dij(int start, int end) {
        distance = new int[n+1];
        check = new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        //시작노드값 초기화
        distance[start] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start,0));

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
        return distance[end];
    }
}
