//백준 알고리즘 10988번 : 팰린드롬인지 확인하기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	String reverse = new StringBuffer(str).reverse().toString();
    	String[] st;
    	st = str.split("");
    	String[] st2;
    	st2 = reverse.split("");
    	

    	for(int i = 0; i<st.length; i++) {
    		if(st[i].equals(st2[i])) 
    			continue;
    		
    		else {
    			System.out.println("0");
    			System.exit(0);
    		}
    	}
    	System.out.println("1");
    }
}
