import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = sc.nextInt();
    	Node root = new Node(num);
        while(sc.hasNext()) {
        	try {
            	num = sc.nextInt();
            	root = insert(root, num);        		
        	}catch(Exception e){
        		break;
        	}
        	
        }
        post(root);
    }
	public static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
		}
	}
		
	public static Node insert(Node node, int value) {
		Node current = null;
		if(node == null) {
			return new Node(value);
		}
			
		if(node.value > value) {
			current = insert(node.left, value);
			node.left = current;
		}
		else {
			current = insert(node.right, value);
			node.right = current;
		}
		return node;
	}	
	
	public static void post(Node node) {
		if(node != null) {
			post(node.left);
			post(node.right);
			System.out.println(node.value);
		}
	}
}
