//백준 알고리즘 2606번 : 바이러스
import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] map;
	static boolean[] visit;
	static int n,m;
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = sc.nextInt();
    	m = sc.nextInt();
    	map = new int[n+1][n+1];
    	visit = new boolean[n+1];
    	int num1, num2;
    	for(int i = 1; i<=m; i++) {
    		num1 = sc.nextInt();
    		num2 = sc.nextInt();
    		map[num1][num2] = map[num2][num1] = 1;
    	}
    	bfs(1);
    }
    
    static void bfs(int b) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int count = 0;
    	queue.add(b);
    	visit[b] = true;
    	while(!queue.isEmpty()) {
        	b = queue.poll();

    		for(int i = 1; i<=n; i++) {
    			if(map[b][i]==1 && !visit[i]) {
    				queue.offer(i);
    				visit[i] = true;
    	        	count++;
    			}
    		}
    	}System.out.println(count);
    }
    
}
