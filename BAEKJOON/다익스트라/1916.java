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
       	int N = Integer.parseInt(br.readLine());
       	int M = Integer.parseInt(br.readLine());
       	
       	ArrayList<Edge>[] list = new ArrayList[N+1];
       	int[] distance = new int[N+1];
       	boolean[] check = new boolean[N+1];
       	
       	for(int i = 1; i<=N; i++) {
       		list[i] = new ArrayList<>();
       	}
       	Arrays.fill(distance,Integer.MAX_VALUE);
       	
       	for(int i = 0 ; i<M; i++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
       		int u = Integer.parseInt(st1.nextToken());
       		int v = Integer.parseInt(st1.nextToken());
       		int w = Integer.parseInt(st1.nextToken());
       		list[u].add(new Edge(v,w));
       	}
       	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int K = Integer.parseInt(st.nextToken());//출발
    	int L = Integer.parseInt(st.nextToken());//도착
       	
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
       	System.out.println(distance[L]);
    }
}
