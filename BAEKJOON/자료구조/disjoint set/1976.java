//백준 알고리즘 1976번 : 여행 가자
import java.io.*;
import java.util.*;
public class Main {
	static int[] parent;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt(); 
    	int m = sc.nextInt();
    	parent = new int[n+1];
    	for(int i = 1; i<=n; i++) {
    		parent[i] = i;
    	}
    	int[][] arr = new int[n+1][n+1];
    	for(int i =1; i<=n; i++) {
    		for(int j = 1; j<=n; j++) {
    			arr[i][j] = sc.nextInt();
    			if(arr[i][j]==1 && arr[j][i] == 0)
    				union(i, j);
    		}
    	}
    	int[] city = new int[m];
    	for(int i = 0 ; i<m; i++) {
    		city[i] = sc.nextInt();
    	}
     	for(int i = 0 ; i<m-1; i++) {
    		if(find(city[i]) != find(city[i+1])) {
    			System.out.println("NO");
    			System.exit(0);
    		}
    	}
    	System.out.println("YES");
	}
    
    public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b)
    		parent[a] = b;
    }
    
    public static int find(int a) {
    	if(parent[a] == a)
    		return a;
    	else
    		return parent[a] = find(parent[a]);
    }
}
