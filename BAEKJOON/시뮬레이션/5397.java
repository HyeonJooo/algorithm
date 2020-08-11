import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<t; i++) {
        	char[] st = br.readLine().toCharArray();
        	StringBuilder sb = new StringBuilder();
        	Stack<Character> stack1 = new Stack<>();
        	Stack<Character> stack2 = new Stack<>();
        	for(int j = 0 ; j<st.length; j++) {
        		if(st[j]=='-' && !stack2.isEmpty()) {
        			stack2.pop();
        		}
        		else if(st[j]=='<' && !stack2.isEmpty()) {
        			stack1.push(stack2.pop());
        		}
        		else if(st[j]=='>' && !stack1.isEmpty()) {
        			stack2.push(stack1.pop());
        		}
        		else if(st[j]!='<' && st[j]!='>' && st[j]!='-') {
        			stack2.push(st[j]);
        		}
        	}
        	while(!stack1.isEmpty())
        		stack2.push(stack1.pop());
        	for(int a = 0; a<stack2.size(); a++) {
        		sb.append(stack2.elementAt(a));
        	}
        	System.out.println(sb);
        }
    }
}
