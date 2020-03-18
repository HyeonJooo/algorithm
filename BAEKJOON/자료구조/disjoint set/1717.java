//백준 알고리즘 1717번 : 집합의 표현
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
    	
    	for(int i = 0 ; i<m; i++) {
    		int num = sc.nextInt();
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		if(num == 0)
    			unionParent(parent, a, b);
    		else {
    			if(findParent(parent, a, b) == 1)
    				System.out.println("YES");
    			else
    				System.out.println("NO");
    		}
    	}
	}
    
    public static int getParent(int parent[], int x) {
    	if(parent[x] == x) return x;
    	return parent[x] = getParent(parent, parent[x]);
    }
    
    public static void unionParent(int parent[], int a, int b) {
    	a = getParent(parent, a);
    	b = getParent(parent, b);
    	if(a < b) parent[b] = a;
    	else parent[a] = b;
    }
    
    public static int findParent(int parent[], int a, int b) {
    	a = getParent(parent, a);
    	b = getParent(parent, b);
    	if(a == b) return 1;
    	else return 0;
    }
}
