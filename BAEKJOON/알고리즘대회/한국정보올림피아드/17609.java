//KOI 2019 1차대회
//백준 알고리즘 17609번 : 회문
import java.io.*;
import java.util.*;
public class Main {
	static String s;
	static String[] st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<n; i++) {
        	s = br.readLine();
        	String reverse = new StringBuffer(s).reverse().toString();
        	
        	if(s.equals(reverse))
        		bw.write(0 + "\n");
        	else {
        		st = s.split("");	
        		
        		if(leftmove(0,s.length()-1)==1 || rightmove(0,s.length()-1)==1)
        			bw.write(1 + "\n");
        		else
        			bw.write(2 + "\n");
        	}
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int leftmove(int left, int right) {
		boolean check = true;
		while(left <= right) {
			if(st[left].equals(st[right])) {
				left++;
				right--;
			}
			else if(check == false) {
				return 2;
			}
			
			else {
				if(st[left+1].equals(st[right])) {
					left++;
				}
				check = false;
			}
		}
		return 1;
    }
    static int rightmove(int left, int right) {
		boolean check = true;
		while(left <= right) {
			if(st[left].equals(st[right])) {
				left++;
				right--;
			}
			else if(check == false) {
				return 2;
			}
			
			else {
				if(st[left].equals(st[right-1])) {
					right--;
				}
				check = false;
			}
		}
		return 1;
    }
}
