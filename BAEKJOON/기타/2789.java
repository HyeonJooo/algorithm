//백준 알고리즘 2789번 : 유학 금지
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	String answer = "";
    	for(int i = 0 ; i<s.length(); i++) {
    		if(s.charAt(i) != 'A' &&s.charAt(i) != 'B' &&s.charAt(i) != 'C'
    				&&s.charAt(i) != 'D' &&s.charAt(i) != 'E' &&s.charAt(i) != 'G' &&
    				s.charAt(i) != 'I' &&s.charAt(i) != 'R'&&s.charAt(i) != 'M')
    			answer += s.charAt(i);
    	}
    	System.out.println(answer);
    }
}
