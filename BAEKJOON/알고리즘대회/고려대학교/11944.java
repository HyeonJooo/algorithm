//2016 고려대학교 프로그래밍 경시대회 3번
//백준 알고리즘 11943번 : NN

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	if(n+n > m) {
    		String[] s;
    		s = Integer.toString(n).split("");
    		for(int i = 0; i<m; i++) {
    			System.out.print(s[i%s.length]);
    		}
    	}
    	else {
    		for(int i = 0 ; i<n; i++) {
    			System.out.print(n);
    		}
    	}
    }
}
