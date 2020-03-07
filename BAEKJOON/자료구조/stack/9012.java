//백준 알고리즘 9012 : 괄호
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++) {
          Stack<String> stack = new Stack<String>();
        	String s = sc.next();
        	String[] st = new String[s.length()];
        	st = s.split("");
        	int count = 0;
        	
        	for(int j = 0; j<st.length; j++) {
        		if(st[j].equals("(")) {
        			stack.push(st[j]);
    				count++;
        		}
        		
        		else {
        			if(stack.isEmpty()) {
        				continue;
        			}
        			else {
        				stack.pop();
        				count++;
        			}
        		}
        	}
          
        	if(stack.isEmpty() && count == st.length)
        		System.out.println("YES");
        	if(!stack.isEmpty() || count != st.length)
        		System.out.println("NO");
        }
    }
}
