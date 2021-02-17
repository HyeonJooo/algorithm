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
       	int K = Integer.parseInt(br.readLine());
       	
       	ArrayList<Edge>[] list = new ArrayList[V+1];
       	int[] distance = new int[V+1];
       	boolean[] check = new boolean[V+1];
       	
       	for(int i = 1; i<=V; i++) {
       		list[i] = new ArrayList<>();
       	}
       	Arrays.fill(distance,Integer.MAX_VALUE);
       	
       	for(int i = 0 ; i<E; i++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
       		int u = Integer.parseInt(st1.nextToken());
       		int v = Integer.parseInt(st1.nextToken());
       		int w = Integer.parseInt(st1.nextToken());
       		list[u].add(new Edge(v,w));
       	}
       	
       	
       	//시작노드값 초기화
       	distance[K] = 0;
       	
       	PriorityQueue<Edge> queue = new PriorityQueue<>();
       	queue.add(new Edge(K,0));
       	
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
       	StringBuilder sb = new StringBuilder();
       	for(int i = 1; i<V+1; i++) {
       		if(check[i])
       			sb.append(distance[i] + "\n");
       		else
       			sb.append("INF" + "\n");
       	}
       	System.out.println(sb.toString());
    }
}
