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
       	int X = Integer.parseInt(st.nextToken());
       	
       	ArrayList<Edge>[] list = new ArrayList[N+1];
       	int[][] distance = new int[N+1][N+1];
       	boolean[][] check = new boolean[N+1][N+1];
       	
       	for(int i = 1; i<=N; i++) {
       		list[i] = new ArrayList<>();
       	}
       	
       	for(int i =1; i<=N; i++) {
       		for(int j =1; j<=N; j++) {
       			distance[i][j] = Integer.MAX_VALUE;
       		}
       	}
       	
       	for(int i = 0 ; i<M; i++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
       		int u = Integer.parseInt(st1.nextToken());
       		int v = Integer.parseInt(st1.nextToken());
       		int w = Integer.parseInt(st1.nextToken());
       		list[u].add(new Edge(v,w));
       	}
       	
       	//시작노드값 초기화

       	for(int i = 1 ; i<N+1; i++) {
           	distance[i][i] = 0;
           	PriorityQueue<Edge> queue = new PriorityQueue<>();
           	queue.add(new Edge(i,0));
           	
           	while(!queue.isEmpty()) {
           		Edge a = queue.poll();
           		if(check[i][a.end])
           			continue;
           		
           		check[i][a.end] = true;
           		for(Edge o : list[a.end]) {
           			if(distance[i][o.end] > distance[i][a.end] + o.value) {
           				distance[i][o.end] = distance[i][a.end] + o.value;
           				queue.add(new Edge(o.end, distance[i][o.end]));
           			}
           		}
           	}
       	}
       	
       	int max = -1;
       	for(int i = 1; i<=N; i++) {
       		max = Math.max(max,  distance[i][X]+distance[X][i]);
       	}
       	System.out.println(max);
    }
}
