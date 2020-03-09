//2016 고려대학교 프로그래밍 경시대회 6번
//백준 알고리즘 11947번 : 이런 반전이
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int i = 0 ; i<t; i++) {
    		int n = sc.nextInt();
    		int count = 0;
    		int tmp = n;
    		while(tmp != 0) {
    			count++;
    			tmp /= 10;
    		}
    		if(n < Math.pow(10, count)/2) {
    			String s1 = Integer.toString(n);
    			String[] st;
    			st = s1.split("");
    			String s2 = "";
    			int[] arr = new int[st.length];
    			for(int j = 0 ; j<arr.length; j++) {
    				arr[j] = 9 - Integer.parseInt(st[j]);
    				s2 += Integer.toString(arr[j]);
    			}
    			long num1 = Long.parseLong(s1);
    			long num2 = Long.parseLong(s2);
    			System.out.println(num1*num2);
    			
    		}
    		else {
    			System.out.println((long)Math.pow(10, count)/2 * (long)(Math.pow(10, count)/2 - 1));
    		}
    	}
    }
}
