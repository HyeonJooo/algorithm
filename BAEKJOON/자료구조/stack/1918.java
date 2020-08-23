import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] st;
		st = s.split("");
		Stack<String> stack = new Stack<>();
		String postfix = "";
		
		for(int i = 0 ; i<st.length; i++) {
			if(st[i].equals("("))
				stack.push(st[i]);
			
			else if(st[i].equals(")")) {
				while(true) {
					String popOp = stack.pop();
					if(popOp.equals("("))
						break;
					postfix += popOp;
				}
			}
			
			else if(st[i].equals("+") || st[i].equals("-")||st[i].equals("*")||st[i].equals("/")) {
				while(!stack.isEmpty() && osCompare(stack.peek(),st[i]) >=0) {
					postfix += stack.pop();
				}
				stack.push(st[i]);
			}
			
			else
				postfix += st[i];
			
		}
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}
		System.out.println(postfix);
	}
	static int osPriority(String op) {
		switch(op) {
		case"*":
		case"/":
			return 3;
		case"+":
		case"-":
			return 2;
		case"(":
			return 1;
		}
		return -1;
	}
	static int osCompare(String op1, String op2) {
		int op1pri = osPriority(op1);
		int op2pri = osPriority(op2);
		
		if(op1pri > op2pri)
			return 1;
		else if(op1pri < op2pri)
			return -1;
		else
			return 0;//우선순위 같은 경우
	}
}
