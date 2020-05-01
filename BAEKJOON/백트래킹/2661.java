//백준 알고리즘 2661번 : 좋은수열
import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static boolean stop;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String tmp = "1";
		go(1, tmp);
		
		
	}
	public static void go(int len, String ans) {
		if(stop == true)
			return;
		
		if(n==len) {
			System.out.println(ans);
			stop = true;
		}
		else {
			for(int i = 1; i<=3; i++) {
				if(check(ans+i)) {
					go(len+1, ans+i);
				}
			}	
		}		
	}
	
	public static boolean check(String s) {
		int left = s.length() - 1;
		int right = s.length();
		 
		for (int i = 1; i <= s.length()/2; i++) {
	        if (s.substring(left - i, right - i).equals(s.substring(left, right))) {
	            return false;
	        }
	        left -= 1;
		}
		return true;
	}
}
