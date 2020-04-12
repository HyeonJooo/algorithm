//백준 알고리즘 10769번 : 행복한지 슬픈지
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	String[] st;
    	st = s.split("");
    	int cnt1 = 0, cnt2 = 0;
    	if(st.length >= 3) {
        	for(int i = 0 ; i<st.length-2; i++) {
            	String tmp = "";
        		tmp += st[i] + st[i+1] + st[i+2];
        		if(tmp.equals(":-)"))
        			cnt1++;
        		else if(tmp.equals(":-("))
        			cnt2++;
        		else
        			continue;
        	}    		
    	}
    	if(cnt1 > cnt2)
    		System.out.println("happy");
    	else if(cnt2 > cnt1)
    		System.out.println("sad");
    	else if(cnt1 == cnt2 && cnt1 == 0)
    		System.out.println("none");
    	else
    		System.out.println("unsure");	
    }
}
