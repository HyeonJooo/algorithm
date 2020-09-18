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
       	int N = Integer.parseInt(st.nextToken());
       	int M = Integer.parseInt(st.nextToken());
       	int K = Integer.parseInt(st.nextToken());//거리길이
       	int X = Integer.parseInt(st.nextToken());//출발도시
       	
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
       		list[u].add(new Edge(v,1));
       	}
       	       	
       	//시작노드값 초기화
       	distance[X] = 0;
       	
       	PriorityQueue<Edge> queue = new PriorityQueue<>();
       	queue.add(new Edge(X,0));
       	
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
       	int num = 0;
       	for(int i = 1; i<N+1; i++) {
       		if(distance[i] == K) {
       			System.out.println(i);
       			num = 1;
       		}
       	}
        if(num ==0)
        	System.out.println(-1);
    }
}
