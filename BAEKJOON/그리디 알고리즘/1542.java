//백준 알고리즘 1543 : 문서 검색

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine(); //문서
        String[] s = st.split("");
        String ans = br.readLine(); //검색하고 싶은 단어 
        int count = 0; //횟수
        
        for(int i = 0; i<=s.length-ans.length(); i++) {
        	String a = "";
        	
        	for(int j = i; j<i+ans.length(); j++) {
        		a += s[j];
        	}
        	
        	if(ans.equals(a)) {
        		count++;
        		i = i +ans.length() -1; //중복되면 안되기 때문
        	}
        }
        System.out.println(count);
    }
}
