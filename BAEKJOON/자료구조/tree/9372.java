import java.io.*;
import java.util.*;
public class Main {
	static HashMap<String, List<String>> map = new HashMap<>();
	static int[] parent;
	static boolean[] visit;
	static List<Integer>[] list;
	public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++) {
    		int n = sc.nextInt();
    		int m = sc.nextInt();
//    		parent = new int[n+1];
//    		list = new ArrayList[n+1];
//    		visit = new boolean[n+1];
//    		for(int i = 1; i<=n; i++) {
//    			list[i] = new ArrayList<>();
//    		}
    		
    		for(int i = 0 ; i<m; i++) {
    			int a = sc.nextInt();
    			int b = sc.nextInt();
//    			list[a].add(b);
//    			list[b].add(a);
    		}
    		System.out.println(n-1);
        }
	}
//	static void tree(int n) {
//		visit[n] = true;
//		
//		for(int k : list[n]) {
//			if(!visit[k]) {
//				parent[k] = n;
//				tree(k);
//			}
//		}
//	}
}
