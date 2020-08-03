import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int length = bomb.length();
        
        for(int i = 0; i<s.length(); i++) {
        	stack.push(s.charAt(i));
        	
        	if(stack.size() >= length) {
        		int ispop = 0;
        		for(int j = 0 ; j<length; j++) {
        			if(stack.get(stack.size() - length + j) != bomb.charAt(j)) {
        				ispop = 1;
        				break;
        			}
        		}
        		if(ispop == 0) {
        			for(int a = 0; a<length; a++) {
        				stack.pop();
        			}
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : stack)
        	sb.append(ch);
        
        String answer = sb.toString();
        if(answer.length()==0)
        	System.out.println("FRULA");
        else
        	System.out.println(answer);
	}
}
