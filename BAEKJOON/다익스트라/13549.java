import java.io.*;
import java.util.*;

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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int num = Math.max(V,E);

        ArrayList<Edge>[] list = new ArrayList[num*2+1];
        int[] distance = new int[num*2+1];
        boolean[] check = new boolean[num*2+1];

        for(int i = 0; i<=num*2; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        list[0].add(new Edge(1,1));

        for(int i = 1; i<=num*2; i++) {
            list[i].add(new Edge(i-1,1));
            list[i].add(new Edge(i+1,1));
            list[i].add(new Edge(i*2,0));
        }

        //시작노드값 초기화
        distance[V] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(V,0));

        while(!queue.isEmpty()) {
            Edge a = queue.poll();
            if(check[a.end])
                continue;

            check[a.end] = true;
            for(Edge o : list[a.end]) {
                if(o.end > num*2 || o.end<0)
                    continue;

                if(distance[o.end] > distance[a.end] + o.value) {
                    distance[o.end] = distance[a.end] + o.value;
                    queue.add(new Edge(o.end, distance[o.end]));
                }
            }
        }
        System.out.println(distance[E]);
    }
}
