//백준 알고리즘 1212번: 8진수 2진수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	String[] st;
    	st = s.split("");
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i<s.length(); i++) {
    		int num = Integer.parseInt(st[i]);
    		if(i != 0 && num<=1)
    			sb.append("00");
    		else if(i != 0 && (num==2 || num==3))
    			sb.append("0");
    		sb.append(Integer.toBinaryString(num));
    	}
    	System.out.println(sb);
    }
}
