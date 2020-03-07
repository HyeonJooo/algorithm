//백준 알고리즘 4949 : 균형잡힌 세상
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            Stack<String> stack = new Stack<String>();
           	String[] st = br.readLine().split("");
            int count = 0;

            if(st[0].equals("."))
           		break;
           	
           	else {
                for(int i = 0; i<st.length; i++) {
                	if(st[i].equals("(") || st[i].equals("[")) {
                		stack.push(st[i]);
                		count++;
                	}
                	
                	else if(st[i].equals(")")) {
                		if(stack.isEmpty() || !stack.peek().equals("("))
                			continue;
                		else {
                			stack.pop();
                			count++;
                		}
                	}
                	
                	else if(st[i].equals("]")) {
                		if(stack.isEmpty() || !stack.peek().equals("["))
                			continue;
                		else {
                			stack.pop();
                			count++;
                		}
                	}
                	
                	else {
                		count++;
                		continue;	                		
                	}

                }
                
            	if(stack.isEmpty() && count == st.length)
            		System.out.println("yes");
            	if(!stack.isEmpty() || count != st.length)
            		System.out.println("no");
           	}	
        }
    }
}
