//백준 알고리즘 5598번 : 카이사르 암호
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	char[] st;
    	st = s.toCharArray();
    	char[] ch = new char[st.length];
    	
    	String word = "";
    	for(int i = 0 ; i<st.length; i++) {
    		int num = (int)st[i] + 23;
    		if(num <= 90)
    			ch[i] = (char)num;
    		else
    			ch[i] = (char)(num%90 + 64);
    		word += String.valueOf(ch[i]);
    	}
    	System.out.println(word);   	
    }
}
