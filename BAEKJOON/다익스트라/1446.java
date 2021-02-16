import java.io.*;
import java.util.*;

//A에서 B로 가는 최소비용 구하기(다익스트라)
class Edge implements Comparable<Edge>{
    int end;
    int value;

    Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] list = new ArrayList[D+1];
        int[] distance = new int[D+1];
        boolean[] check = new boolean[D+1];

        for(int i = 0; i<=D; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int i = 0 ; i<N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            if(u>D || v>D)
                continue;
            list[u].add(new Edge(v,w));
        }

        for(int i = 0 ; i<D; i++) {
            list[i].add(new Edge(i+1, 1));
        }

        //시작노드값 초기화
        distance[0] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(0,0));

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
        System.out.println(distance[D]);
    }
}
