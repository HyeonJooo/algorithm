import java.io.*;
import java.util.*;
public class Main {
	static int[] parent;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        parent = new int[g+1];
        int cnt = 0;
        
        for(int i = 1; i<=g; i++) {
        	parent[i] = i;
        }
        for(int i = 1; i<=p; i++) {
        	int num = sc.nextInt();
        	int check = find(num);
        	if(check != 0) {
        		union(check, check-1);
        		cnt++;
        	}
        	else
        		break;
        }
        System.out.println(cnt);
        
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
