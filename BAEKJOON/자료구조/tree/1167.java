import java.io.*;
import java.util.*;
class Node{
	int to;
	int cost;
	public Node(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}

public class Main {
	static int v;
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		List<Node>[] list = new ArrayList[v+1];
		int[] dist = new int[v+1];
		list = new ArrayList[v+1];
		boolean[] visit = new boolean[v+1];
		for(int i = 1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i<v; i++) {
			int num = sc.nextInt();
			while(true) {
				int to = sc.nextInt();
				if(to==-1)
					break;
				int cost = sc.nextInt();
				list[num].add(new Node(to, cost));
			}
		}
		dist = bfs(list, 1);
		int max = 1;
		for(int i = 2; i<=v; i++) {
			if(dist[max] < dist[i])
				max = i;
		}
		dist = bfs(list, max);
		Arrays.sort(dist);
		System.out.println(dist[v]);
		
	}
	
	static int[] bfs(List<Node>[] list, int start) {
		boolean[] visit = new boolean[v+1];
		int[] dist = new int[v+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			for(Node n : list[num]) {
				int to = n.to;
				int cost = n.cost;
				if(!visit[to]) {
					visit[to] = true;
					dist[to] = dist[num] + cost;
					queue.add(to);
				}
			}
		}
		return dist;
	}
}
