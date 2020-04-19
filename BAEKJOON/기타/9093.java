//백준 알고리즘 9093번 : 단어 뒤집기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	for(int i = 0 ; i<t; i++) {
    		String s = br.readLine();
    		String[] st;
    		st = s.split(" ");
    		for(int j = 0; j<st.length; j++) {
    			String reverse = new StringBuffer(st[j]).reverse().toString();
    			System.out.print(reverse + " ");
    		}
    		System.out.println("");
    	}
    }
}
