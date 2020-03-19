//백준 알고리즘 4195번 : 친구 네트워크
import java.io.*;
import java.util.*;
public class Main {
	static HashMap<String, Integer> hm = new HashMap<>();
	static int[] parent = new int[200002];
	static int[] friend = new int[200002];
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int i = 0 ; i<t; i++) {
        	int f = sc.nextInt();
        	int cnt = 1;
        	for(int k = 1; k<=2*f; k++) {
        		parent[k] = k;
        		friend[k] = 1;
        	}
        	
        	for(int j = 0; j<f; j++) {
        		String a = sc.next();
        		String b = sc.next();
        		
        		if(!hm.containsKey(a))
        			hm.put(a, cnt++);
        		if(!hm.containsKey(b))
        			hm.put(b, cnt++);
        		
        		System.out.println(union(hm.get(a), hm.get(b)));
        	}
    	}
	}
    
    public static int union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b) {
    		parent[b] = a;
    		friend[a] += friend[b];
    		friend[b] = 1;
    	}
    	return friend[a];
    }
    
    public static int find(int a) {
    	if(parent[a] == a)
    		return a;
    	else
    		return parent[a] = find(parent[a]);
    }
}
