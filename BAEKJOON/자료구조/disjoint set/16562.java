import java.io.*;
import java.util.*;
public class Main {
	static int[] parent;
	static int[] arr;
	public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n+1];
        parent = new int[n+1];
        for(int i = 1 ; i<=n; i++) {
        	arr[i] = sc.nextInt();
        }
        
        for(int i =1 ; i<=n; i++) {
        	parent[i] = i;
        }
        
        for(int i = 0 ; i<m; i++) {
        	int v = sc.nextInt();
        	int w = sc.nextInt();
        	union(v,w);
        }
        
        int sum = 0;
        for(int i = 1; i<=n; i++) {
        	if(find(i) != 0) {
        		sum += arr[find(i)];
        		union(0, find(i));
        	}
        }
        
        if(sum <= k)
        	System.out.println(sum);
        else
        	System.out.println("Oh no");
	}
    
    public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a==b)
    		return;
    	if(arr[a] > arr[b])
    		parent[a] = b;
    	else
    		parent[b] = a;
    }
    
    public static int find(int a) {
    	if(parent[a] == a)
    		return a;
    	else
    		return parent[a] = find(parent[a]);
    }
}
