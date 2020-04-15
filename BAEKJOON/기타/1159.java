//백준 알고리즘 : 1159번 : 농구 경기
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n  = sc.nextInt();
    	int[] arr = new int[26];
    	for(int i = 0 ; i<n; i++) {
    		String s = sc.next();
    		char tmp = s.charAt(0);
    		arr[(int)tmp-97]++;
    	}
    	int check = 0;
    	for(int i = 0; i<26; i++) {
    		if(arr[i] >=5) {
    			System.out.print((char)(i+97));
    			check = 1;
    		}
    	}
    	if(check == 0)
    		System.out.println("PREDAJA");
    }
}
