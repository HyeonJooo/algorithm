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
	static List<Node>[] list;
   public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        long[] dist1 = new long[n+1];
        for(int i = 1; i<=n; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<n-1; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int parent = Integer.parseInt(st.nextToken());
        	int child = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, cost));
            list[child].add(new Node(parent, cost));
        }
        int max1 = 0;
        int max2 = 0;
        dist1 = bfs(1, n);
        for(int i = 2; i<=n; i++) {
         if(dist1[max1] < dist1[i])
            max1 = i;//1에서 가장먼 노드번호
      }
        
       dist1 = bfs(max1, n);
       for(int i = 1; i<=n; i++) {
           if(dist1[max2] < dist1[i])
              max2 = i;
       }
       
       long ans1 = 0, ans2 = 0;
       Arrays.sort(dist1);
       ans1 = dist1[n-1];
       
       dist1 = bfs(max2, n);
       Arrays.sort(dist1);
       ans2 = dist1[n-1];
       
       System.out.println(Math.max(ans1, ans2));
   }
      
   static long[] bfs(int start, int s) {
      boolean[] visit = new boolean[s+1];
      long[] dist = new long[s+1];
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
