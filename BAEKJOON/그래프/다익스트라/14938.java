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
       	int n = Integer.parseInt(st.nextToken());//지역개수
       	int m = Integer.parseInt(st.nextToken());//수색범위
       	int r = Integer.parseInt(st.nextToken());//길의개수
       	
       	int[] item = new int[n+1];
    	StringTokenizer st1 = new StringTokenizer(br.readLine());       	
       	for(int i = 1; i<=n; i++) {
       		item[i] = Integer.parseInt(st1.nextToken());
       	}
    	
    	ArrayList<Edge>[] list = new ArrayList[n+1];
       	int[][] distance = new int[n+1][n+1];
       	boolean[][] check = new boolean[n+1][n+1];
       	
       	for(int i = 1; i<=n; i++) {
       		list[i] = new ArrayList<>();
       	}
      	for(int i =1; i<=n; i++) {
       		for(int j =1; j<=n; j++) {
       			distance[i][j] = Integer.MAX_VALUE;
       		}
       	}
       	
       	for(int i = 0 ; i<r; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
       		int a = Integer.parseInt(st2.nextToken());
       		int b = Integer.parseInt(st2.nextToken());
       		int l = Integer.parseInt(st2.nextToken());
       		list[a].add(new Edge(b,l));
       		list[b].add(new Edge(a,l));
       	}
       	
       	for(int i = 1; i<=n; i++) {
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
       	for(int i =1; i<=n; i++) {
       		int tmp = 0;
       		for(int j =1; j<=n; j++) {
       			if(distance[i][j]<=m)
       				tmp += item[j];
       		}
       		max = Math.max(max, tmp);
       	}
       	System.out.println(max);
    }
}
