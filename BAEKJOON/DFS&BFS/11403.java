//백준 알고리즘 11403번 : 경로 찾기
import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] map;
	static int v;
	static Queue<Integer> queue = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
       	int tmp;       
       	map = new int[v][v];
       	for(int i = 0; i<v; i++) {
       		for(int j = 0; j<v; j++){
       			map[i][j] = sc.nextInt();
       		}
       	}
	
       	for(int i = 0; i<v; i++) {
       		for(int j = 0; j<v; j++) {
       			if(map[i][j]==1) {
       				queue.add(j);       				
       			}
       		}

       		while(!queue.isEmpty()) {
       			tmp = queue.poll();
       			bfs(i,tmp);
       		}
       	}
       		
       	for(int i = 0; i<v; i++) {
       		for(int j = 0; j<v; j++) {
       			System.out.print(map[i][j]+ " ");
       		}System.out.println("");
       	}
       	
    }
    
    static void bfs(int i, int tmp) {
    	map[i][tmp] = 1;
    	for(int j = 0; j<map[0].length; j++) {
    		if(map[tmp][j]==1 && map[i][j]!=1) {
    			queue.add(j);
    		}
    	}
    }
}
