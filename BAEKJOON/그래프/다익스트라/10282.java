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
    	int t = Integer.parseInt(br.readLine());
    	for(int tc = 0; tc<t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
           	int n = Integer.parseInt(st.nextToken());
           	int d = Integer.parseInt(st.nextToken());
           	int c = Integer.parseInt(st.nextToken());           	
           	
        	ArrayList<Edge>[] list = new ArrayList[n+1];
           	int[] distance = new int[n+1];
           	int[] trace = new int[n+1];
           	boolean[] check = new boolean[n+1];
           	
           	for(int i = 1; i<=n; i++) {
           		list[i] = new ArrayList<>();
           	}
           	Arrays.fill(distance, Integer.MAX_VALUE);
           	
           	for(int i = 0 ; i<d; i++) {
            	StringTokenizer st2 = new StringTokenizer(br.readLine());
           		int a = Integer.parseInt(st2.nextToken());
           		int b = Integer.parseInt(st2.nextToken());
           		int s = Integer.parseInt(st2.nextToken());
           		list[b].add(new Edge(a,s));
           	}
           	
           	distance[c] = 0;
           	
           	PriorityQueue<Edge> queue = new PriorityQueue<>();
           	queue.add(new Edge(c,0));
           	
           	while(!queue.isEmpty()) {
           		Edge a = queue.poll();
           		if(check[a.end])
           			continue;
           		
           		check[a.end] = true;
           		for(Edge o : list[a.end]) {
           			if((distance[o.end] > distance[a.end] + o.value)) {
           				distance[o.end] = distance[a.end] + o.value;
           				queue.add(new Edge(o.end, distance[o.end]));
           				trace[o.end]= a.end;
           			}
           		}
           	}
           	int cnt = 0, max = 0;
           	for(int i = 1; i<=n; i++) {
           		if(distance[i] != Integer.MAX_VALUE) {
           			cnt++;
           			max = Math.max(max, distance[i]);
           		}
           	}
           	System.out.println(cnt + " " + max);
    	}
    }
}
