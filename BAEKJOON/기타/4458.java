//백준 알고리즘 4458번 : 첫 글자를 대문자로
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	//Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	for(int i = 0 ; i<n; i++) {
    		String s = br.readLine();
    		String[] st;
    		st = s.split("");
    		st[0] = st[0].toUpperCase();
    		for(int j = 0; j<st.length; j++) {
    			System.out.print(st[j]);
    		}
    		System.out.println("");
    	}
    }
}
