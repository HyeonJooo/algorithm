import java.io.*;
import java.util.*;
public class Main {
	static HashMap<String, List<String>> map = new HashMap<>();
	public static void main(String args[]) throws IOException{
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++) {
        	String s = br.readLine();
        	String[] st;
        	st = s.split(" ");
        	List<String> list = new ArrayList<>();
        	list.add(st[1]);
        	list.add(st[2]);
        	map.put(st[0], list);
        }
        
        preorder("A");
        System.out.println("");
        inorder("A");
        System.out.println("");
        postorder("A");
        System.out.println("");
    }
	
		static void preorder(String v) {
			if(v.equals("."))
				return;
			
			System.out.print(v);
			preorder(map.get(v).get(0));
			preorder(map.get(v).get(1));
		}
		
		static void inorder(String v) {
			if(v.equals("."))
				return;

			inorder(map.get(v).get(0));
			System.out.print(v);
			inorder(map.get(v).get(1));
		}
		
		static void postorder(String v) {
			if(v.equals("."))
				return;

			postorder(map.get(v).get(0));
			postorder(map.get(v).get(1));
			System.out.print(v);
		}
}
