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
	static int[] distance1;
	static int[] distance2;
	static int[] distance3;
	static boolean[] check;
	static ArrayList<Edge>[] list;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringTokenizer st2 = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st2.nextToken());
       	int M = Integer.parseInt(st2.nextToken());
       	
       	list = new ArrayList[N+1];
       	distance1 = new int[N+1];
       	distance2 = new int[N+1];
       	distance3 = new int[N+1];
       	check = new boolean[N+1];
       	
       	for(int i = 1; i<=N; i++) {
       		list[i] = new ArrayList<>();
       	}
       	Arrays.fill(distance1,Integer.MAX_VALUE);
       	Arrays.fill(distance2,Integer.MAX_VALUE);
       	Arrays.fill(distance3,Integer.MAX_VALUE);
       	
       	for(int i = 0 ; i<M; i++) {
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
       		int u = Integer.parseInt(st1.nextToken());
       		int v = Integer.parseInt(st1.nextToken());
       		int w = Integer.parseInt(st1.nextToken());
       		list[u].add(new Edge(v,w));
       		list[v].add(new Edge(u,w));
       	}
       	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int v1 = Integer.parseInt(st.nextToken());
    	int v2 = Integer.parseInt(st.nextToken());
       
    	long ans1 = 0, ans2 = 0, ans = 0;
    	
    	bfs(1, distance1);//1번노드에서 각 정점까지 거리
    	ans1 += distance1[v1];//1번에서 v1까지 최소거리
    	ans2 += distance1[v2];//1번에서 v2까지 최소거리
    	reset(N);
    	
    	bfs(v1,distance2);//v1에서 각 정점까지 거리
    	reset(N);
    	bfs(v2,distance3);//v2에서 각 정점까지 거리
    	
    	ans1 += distance2[v2];//v1에서 v2까지 최소거리
    	ans1 += distance3[N];//v2에서 B까지 최소거리
    	ans2 += distance3[v1];//v2에서 v1까지 최소거리
    	ans2 += distance2[N];//v1에서 N까지 최소거리
    	ans = Math.min(ans1, ans2);
    	
    	if(ans >= Integer.MAX_VALUE)
           	System.out.println(-1);
    	else
    		System.out.println(ans);
    }
    
    static void reset(int N) {
       	check = new boolean[N+1];
       	
       	for(int i = 1; i<=N; i++) {
       		check[i] = false;
       	}
    }
    
    static void bfs(int k, int[] distance) {
    	//시작노드값 초기화
       	distance[k] = 0;
       	
       	PriorityQueue<Edge> queue = new PriorityQueue<>();
       	queue.add(new Edge(k,0));
       	
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
    }
}
