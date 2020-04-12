//백준 알고리즘 2998번 : 8진수
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	while(s.length() % 3 != 0) {
    		s = "0" + s;
    	}
    	String[] st;
    	st = s.split("");

    	for(int i = 0; i<st.length-2; i+=3) {
        	String ans = "";
    		ans += st[i] + st[i+1] + st[i+2];
    		if(ans.equals("000"))
    			System.out.print(0);
    		else if(ans.equals("001"))
    			System.out.print(1);
    		else if(ans.equals("010"))
    			System.out.print(2);
    		else if(ans.equals("011"))
    			System.out.print(3);
    		else if(ans.equals("100"))
    			System.out.print(4);
    		else if(ans.equals("101"))
    			System.out.print(5);
    		else if(ans.equals("110"))
    			System.out.print(6);
    		else
    			System.out.print(7);
    	}
    }
}
